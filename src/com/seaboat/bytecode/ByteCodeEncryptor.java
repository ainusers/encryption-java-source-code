package com.seaboat.bytecode;

/*
 * @Author: tianyong
 * @Date: 2020/9/17 13:41
 * @Description: 字节码加密
 */
public class ByteCodeEncryptor {
  static{
    System.load("C:\\Users\\Administrator\\Desktop\\test\\hello.dll");
  }
  
  public native static byte[] encrypt(byte[] text);
  
}
