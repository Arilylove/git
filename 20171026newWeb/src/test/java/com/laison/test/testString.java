package com.laison.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.codec.Hex;
import org.junit.Test;

import com.laison.common.utils.StringUtils;

public class testString {
	@Test
	public void test() {
		byte[] bytes = StringUtils.getBytes("10101010100000111");
		for (int i = 0; i < bytes.length; i++) {
			byte b = bytes[i];

			System.out.println("第" + i + "个bit是：" + b);
		}
	}

	@Test
	public void testHexStringToBytes() {

		byte[] bytes = StringUtils.hexString2Bytes("af1e1a");
		for (int i = 0; i < bytes.length; i++) {
			byte b = bytes[i];

			System.out.println("第" + i + "个bit是：" + b);
		}
	}

	@Test
	public void binaryStringToHexString() {
		String a="000000001010101010000011100000000";
		String binaryStringToHexString = StringUtils.binaryStringToHexString(a);
		System.out.println(binaryStringToHexString);
	}
	@Test
	public void cut() {

		String a="0155070";
		List<String> cutStr = StringUtils.cutStr(a, 2);
		StringBuffer sb = new StringBuffer();
		for (String string : cutStr) {
			String binaryString = Integer.toBinaryString(Integer.parseInt(string, 16));
			int length = binaryString.length();
			if(binaryString.length()<8){                        
				   for(int i=0;i<8-length;i++) {
					   binaryString = "0"+binaryString;      //在不足的位数前都加“0”
				   }		                
			}
			sb.append(binaryString);
			
		}
		
		System.out.println(sb.toString());
	}
	
	@Test
	public void isHex() {
		String a ="a2a3a2gg";
		
		System.out.println(StringUtils.isHexString(a, 6));
	}
	
}
