package com.laison.test;
import org.junit.Test;
import com.laison.common.utils.AesUtils;



public class TestAes {
	@Test
	public void test() {
		
		
	}
	 @Test
	 public void testAesCipherService() throws Exception {
		
		 String encrptText = AesUtils.EncryptHexString("00010203040506070809AABBCCDDEEFF",AesUtils.encryptKey);
		 String decryptHexString = AesUtils.DecryptHexString("805694E7542491FF3086E872547943CA",AesUtils.encryptKey);
		 System.out.println(encrptText);
		 System.out.println(decryptHexString);
		 
		 String encrptText2 = AesUtils.encrptText("123456");
		 System.out.println(encrptText2);
		 String decryptText = AesUtils.decryptText("1fxenjASH48I5w+qxzmtDg==");
		 System.out.println(decryptText);
	 }
}
