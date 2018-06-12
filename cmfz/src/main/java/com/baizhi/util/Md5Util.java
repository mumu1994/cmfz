package com.baizhi.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Util {
	public static String encryption(String password){
		return DigestUtils.md5Hex(password);
	}
	public static boolean checkPassword(String userPass,String dbPass){
		if( dbPass.equals( encryption(userPass) ))  return true;
		else return false;
	}
}
