package com.laison.common.utils;

import org.apache.commons.codec.binary.Base64;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AesUtils {
	public static String encryptKey = "001122334455667788990A0B0C0D0E0F";

	public static String encrptText(String content)  {

		try {
			return Encrypt(content, encryptKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String decryptText(String content)  {
		try {
			return Decrypt(content, encryptKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	// 加密
    public static String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        
        
        byte[] raw = StringUtils.hexString2Bytes(sKey);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
 
        return new Base64().encodeToString(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }
    public static String EncryptHexString(String hexSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
       
        
        byte[] raw = StringUtils.hexString2Bytes(sKey);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        //Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(StringUtils.hexString2Bytes(hexSrc));
        
        return StringUtils.bytes2HexString(encrypted);
    }
 
    // 解密
    public static String Decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
           
            byte[] raw = StringUtils.hexString2Bytes(sKey);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new Base64().decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    // 解密
    public static String DecryptHexString(String hexStringSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            
            byte[] raw = StringUtils.hexString2Bytes(sKey);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = StringUtils.hexString2Bytes(hexStringSrc);
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = StringUtils.bytes2HexString(original);
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
	
}
