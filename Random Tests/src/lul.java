import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class lul {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int g = s.nextInt();
		FileWriter someFile = null;
		try {
			someFile = new FileWriter("some.txt");
			someFile.write("You are learning some nice things m8");
			System.out.println("okay");

		} finally {
			someFile.close();
			s.close();

		}
	}

}
