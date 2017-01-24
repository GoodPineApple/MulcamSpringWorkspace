package pack;

import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;

//import org.apache.commons.codec.binary.Hex;


//AES 대칭키 : 암호화 복호화 시험키가 동일. 키 공유가 이슈.
//RSA 공개키 : 암호화 복호화 키가 다름. 비용이 비싸다.(처리 시간, cpu작업) 개인키를 소지한 사람이 정확한지에 대한 이슈

public class TestAES {


	private static String message = "This is just an example";

	public static void main(String[] args) throws Exception {

//		// 1. 128 비트 비밀키 생성
//
//		KeyGenerator kgen = KeyGenerator.getInstance("AES");
//
//		kgen.init(128);
//
//		SecretKey skey = kgen.generateKey();
//
//		// 2. 비밀 키를 이렇게 저장하여 사용하면 암호화/복호화가 편해진다.
//
//		sKeyString = Hex.encodeHexString(skey.getEncoded());
		
		byte[] sKey = new byte[16];
		String key = "12345678901234567890123456789012";
		sKey = key.getBytes();

		// 3. 암호화 수행
		SecretKeySpec skeySpec = new SecretKeySpec(sKey, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(message.getBytes());
		System.out.println("encrypted string: " + new String(encrypted));

		// 4. 복호화 수행
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] original = cipher.doFinal(encrypted);
		String originalString = new String(original);
		System.out.println("Original string: " + originalString);

	}

}

