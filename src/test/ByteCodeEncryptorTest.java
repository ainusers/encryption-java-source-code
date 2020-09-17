package test;


import com.seaboat.bytecode.ByteCodeEncryptor;

/*
 * @Author: tianyong
 * @Date: 2020/9/17 13:46
 * @Description: 调用C++加密程序
 */
public class ByteCodeEncryptorTest {
  
  public static void main(String[] args) {
    byte[] texts = "qwertyuio".getBytes();
    for (byte b : texts)
      System.out.println(b);
    System.out.println("==========华丽分割线============");
    byte[] bytes = ByteCodeEncryptor.encrypt(texts);
    for (byte b : bytes)
      System.out.println(b);
  }
  
}
