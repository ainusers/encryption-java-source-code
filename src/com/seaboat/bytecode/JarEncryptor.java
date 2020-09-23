package com.seaboat.bytecode;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;

/*
 * @Author: tianyong
 * @Date: 2020/9/17 13:41
 * @Description: jar加密
 */
public class JarEncryptor {

  public static void encrypt(String fileName){
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      byte[] buf = new byte[1024];
      File srcFile = new File(fileName);
      File dstFile = new File(fileName.substring(0, fileName.lastIndexOf("."))+"_encrypted.jar");
      FileOutputStream dstFos = new FileOutputStream(dstFile);
      JarOutputStream dstJar = new JarOutputStream(dstFos);
      JarFile srcJar = new JarFile(srcFile);
      for (Enumeration<JarEntry> enumeration = srcJar.entries(); enumeration.hasMoreElements();) {
          JarEntry entry = enumeration.nextElement();
          InputStream is = srcJar.getInputStream(entry);
          int len;
          while ((len = is.read(buf, 0, buf.length)) != -1) {
              baos.write(buf, 0, len);
          }
          byte[] bytes = baos.toByteArray();
          String name = entry.getName();
          if(name.startsWith("com/data/demo/controller/") && name.endsWith(".class")){
              System.out.println("加密的类：" + name);
              try {
                  bytes = ByteCodeEncryptor.encrypt(bytes);
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
          JarEntry ne = new JarEntry(name);
          dstJar.putNextEntry(ne);
          dstJar.write(bytes);
          baos.reset();
      }
      srcJar.close();
      dstJar.close();
      dstFos.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
}
