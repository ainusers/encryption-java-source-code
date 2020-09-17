# java项目加密，防止反编译

<h2>1. 注意事项</h2>
1. 该环境测试，主要是window环境，linux请自行测试，(可以测试cpp转so)

2. 启动类不能加密

3. 通过idea工具中的jar，可以反编译，命令如下<br/>
java -cp "java-decompiler.jar" org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler -dgs=true a.jar cc

<h2>2. 思想</h2>
1. java调用c++，c++调用c

2. 主要因为c++，c有天然的语言保护，不能反编译

<h2>3. 文件说明</h2>
1. 项目用到的文件，都在native目录下，里面有加密好的jar以及c++，c源代码

2. dll文件，需要你们自己生成，因为cpp文件中有自定义路径，打包的时候，不要用mingw-w64
   我用gcc命令编译，一直有错
   
3. 如果报错信息如下(魔数不对)，说明，加解密路径不一致
 Incompatible magic value 3338319546 in class file
 
 4. 如果是springboot项目做测试，需要自定义打包路径，默认的打包，文件会搜不到
 
 <h2>4. 步骤</h2>
 1. 前提是，需要的dll文件，需要的加密的jar包都已准备好
 
 2. 先运行ByteCodeEncryptorTest (有时候一次有错，在运行一次就好了，除非是真的有错)
 
 3. 运行JarEncryptorTest生成加密之后的jar，会放在和需要加密的jar同级目录