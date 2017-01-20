package ss.week5;

import java.util.Base64;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * A simple class that experiments with the Hex encoding of the Apache Commons
 * Codec library.
 *
 */
public class EncodingTest {
	public static void main(String[] args) throws DecoderException {
		String input = "Hello Big World"; // 48656c6c6f2042696720576f726c64
		String hexString = "4d6f64756c652032";
		byte[] b = Hex.decodeHex(hexString.toCharArray());
		String baseString = "Hello World";
		String hexString1 = "010203040506"; // 010203040506
		String input2 = "U29mdHdhcmUgU3lzdGVtcw==";
		byte[] a = Base64.getDecoder().decode(hexString1);

		System.out.println(Hex.encodeHexString(input.getBytes()));
		System.out.println(new String(b));
		System.out.println(new String(Base64.getEncoder().encode(baseString.getBytes())));
		System.out.println(new String(Base64.getEncoder().encode(a)));
		System.out.println(new String(Base64.getDecoder().decode(input2.getBytes())));
		System.out.println(new String(Base64.getEncoder().encode("a".getBytes())));
		System.out.println(new String(Base64.getEncoder().encode("aa".getBytes())));
		System.out.println(new String(Base64.getEncoder().encode("aaa".getBytes())));
		System.out.println(new String(Base64.getEncoder().encode("aaaa".getBytes())));
		System.out.println(new String(Base64.getEncoder().encode("aaaaa".getBytes())));
		System.out.println(new String(Base64.getEncoder().encode("aaaaaa".getBytes())));
		System.out.println(new String(Base64.getEncoder().encode("aaaaaaa".getBytes())));
		System.out.println(new String(Base64.getEncoder().encode("aaaaaaaa".getBytes())));
		System.out.println(new String(Base64.getEncoder().encode("aaaaaaaaa".getBytes())));
		System.out.println(new String(Base64.getEncoder().encode("aaaaaaaaaa".getBytes())));
	}
}