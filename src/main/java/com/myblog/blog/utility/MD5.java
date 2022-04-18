package com.myblog.blog.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ClassName:MD5
 * Package:com.ry.blog.Util
 * Description:
 *
 * @Date:2020/5/7 10:25
 * @com.chuangmei
 */
public class MD5 {

	public static String getMD5(String str) {

		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(str.getBytes());
			byte[] byteDiget = messageDigest.digest();
			int i;
			StringBuffer stringBuffer = new StringBuffer("");
			for (int offset = 0; offset < byteDiget.length; offset++) {
				i = byteDiget[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					stringBuffer.append("0");
				stringBuffer.append(Integer.toHexString(i));
			}
			//32位
			return stringBuffer.toString();
		} catch (NoSuchAlgorithmException exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		System.out.println(getMD5("Zlq123456.."));
	}

}
