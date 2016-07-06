package com.tkb.elearning.util;

import sso.spring.DeployInfoUtil;
import tkb.util.crypto.DES;
import tkb.util.string.Hex;

/**
 * DES加解密
 * @author Ken
 * @version 創建時間：2016-02-01
 */
public class DesEncrypt {
	
	/**
	 * DES加密
	 * @param password
	 * @param desKey
	 * @param desModeAndPadding
	 * @return
	 */
	public static String desEncrypt(String password, String desKey, String desModeAndPadding){
		DES des = new DES(desKey, desModeAndPadding);
		byte[] encrypted = des.encrypt(password.getBytes());
		String hexedPwd = Hex.hexEncode(encrypted);
		return hexedPwd;
	}
	
	/**
	 * DES解密
	 * @param password
	 * @param desKey
	 * @param desModeAndPadding
	 * @return
	 */
	public static String desDecrypt(String password, String desKey, String desModeAndPadding){
		DES des = new DES(desKey, desModeAndPadding);
		byte[] hexedPwd = Hex.hexDecode(password);
		String encrypted = des.decrypt(hexedPwd);		
		return encrypted;
	}
	
	/**
	 * 加密
	 * @param password
	 * @return
	 */
	public static String desEncrypt(String password){
		String desKey = DeployInfoUtil.getDesKey();
		String desModeAndPadding = DeployInfoUtil.getDesModeAndPadding();
		return DesEncrypt.desEncrypt(password, desKey, desModeAndPadding);
	}
	
	/**
	 * 解密
	 * @param password
	 * @return
	 */
	public static String desDecrypt(String password){
		String desKey = DeployInfoUtil.getDesKey();
		String desModeAndPadding = DeployInfoUtil.getDesModeAndPadding();
		return DesEncrypt.desDecrypt(password, desKey, desModeAndPadding);
	}
	
	/**
	 * 加密
	 * @param password
	 * @return
	 */
	public static String desEncrypt(Integer password){
		String desKey = DeployInfoUtil.getDesKey();
		String desModeAndPadding = DeployInfoUtil.getDesModeAndPadding();
		return DesEncrypt.desEncrypt(String.valueOf(password), desKey, desModeAndPadding);
	}
	
	/**
	 * 解密
	 * @param password
	 * @return
	 */
	public static String desDecrypt(Integer password){
		String desKey = DeployInfoUtil.getDesKey();
		String desModeAndPadding = DeployInfoUtil.getDesModeAndPadding();
		return DesEncrypt.desDecrypt(String.valueOf(password), desKey, desModeAndPadding);
	}
	
}
