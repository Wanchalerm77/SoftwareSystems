package ss.week6.dictionaryattack;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.codec.binary.Hex;

public class DictionaryAttack {
	private Map<String, String> passwordMap = new HashMap<String, String>();
	private Map<String, String> hashDictionary = new HashMap<String, String>();

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled withthe content of the file. The key for the map should be the
	 * username, and the password hash should be the content.
	 * 
	 * @param filename
	 * @throws IOException
	 */
	public void readPasswords(String filename) throws IOException {
		try (Scanner scan = new Scanner(new FileReader(filename))) {
			while (scan.hasNextLine()) {
				String[] parts = scan.nextLine().split(": ");
				passwordMap.put(parts[0], parts[1]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting hash
	 * (or sometimes called digest) should be hex-encoded in a String.
	 * 
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return new String(Hex.encodeHex(md.digest(password.getBytes())));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Checks the password for the user the password list. If the user does not
	 * exist, returns false.
	 * 
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
		passwordMap.put(user, password);
		return (passwordMap.get(user).equals(password));
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to the
	 * original password.
	 * 
	 * @param filename
	 *            filename of the dictionary.
	 */
	public void addToHashDictionary(String filename) {
		try (Scanner scan = new Scanner(new FileReader(filename))) {
			while (scan.hasNextLine()) {
				String plain = scan.nextLine();
				hashDictionary.put(plain, getPasswordHash(plain));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		for (String user : passwordMap.keySet()) {
			for (String hashPassword : hashDictionary.keySet()) {
				if (passwordMap.get(user).equals(hashDictionary.get(hashPassword))) {
					System.out.println("Username:" + user + " Password:" + hashPassword);

				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		DictionaryAttack da = new DictionaryAttack();
		da.readPasswords("LeakedPasswords.txt");
		da.addToHashDictionary("password.txt");
		da.doDictionaryAttack();
	}

}
