package com.lm.tobacco.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author liming356
 * @since 2018/9/25/025
 */
public class HashUtil {

  public static String getSHA256Byte(byte[] bytes) {
    MessageDigest messageDigest;
    String encodeStr = "";
    try {
      messageDigest = MessageDigest.getInstance("SHA-256");
      messageDigest.update(bytes);
      encodeStr = byte2Hex(messageDigest.digest());
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return encodeStr;
  }

  /**
   * 利用java原生的摘要实现SHA256加密
   *
   * @param str 加密后的报文
   * @return
   */
  public static String getSHA256Str(String str) {
    return getSHA256Byte(str.getBytes());
  }

  /**
   * 将byte转为16进制
   *
   * @param bytes
   * @return
   */
  private static String byte2Hex(byte[] bytes) {
    StringBuffer stringBuffer = new StringBuffer();
    String temp = null;
    for (int i = 0; i < bytes.length; i++) {
      temp = Integer.toHexString(bytes[i] & 0xFF);
      if (temp.length() == 1) {
        // 1得到一位的进行补0操作
        stringBuffer.append("0");
      }
      stringBuffer.append(temp);
    }
    return stringBuffer.toString();
  }
}
