```
public class TestJvm {
    public String str = "NotStaticStr";
}
```
```
G:\liuxiang_code_git\myServer\@jvm\demo-jvm\target\classes>javap -v TestJvm.class
Classfile /G:/liuxiang_code_git/myServer/@jvm/demo-jvm/target/classes/TestJvm.class
  Last modified 2017-7-2; size 319 bytes
  MD5 checksum 9c16345e55c56db2b98e673257535302
  Compiled from "TestJvm.java"
public class TestJvm
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #5.#17         // java/lang/Object."<init>":()V
   #2 = String             #18            // NotStaticStr
   #3 = Fieldref           #4.#19         // TestJvm.str:Ljava/lang/String;
   #4 = Class              #20            // TestJvm
   #5 = Class              #21            // java/lang/Object
   #6 = Utf8               str
   #7 = Utf8               Ljava/lang/String;
   #8 = Utf8               <init>
   #9 = Utf8               ()V
  #10 = Utf8               Code
  #11 = Utf8               LineNumberTable
  #12 = Utf8               LocalVariableTable
  #13 = Utf8               this
  #14 = Utf8               LTestJvm;
  #15 = Utf8               SourceFile
  #16 = Utf8               TestJvm.java
  #17 = NameAndType        #8:#9          // "<init>":()V
  #18 = Utf8               NotStaticStr
  #19 = NameAndType        #6:#7          // str:Ljava/lang/String;
  #20 = Utf8               TestJvm
  #21 = Utf8               java/lang/Object
{
  public java.lang.String str;
    descriptor: Ljava/lang/String;
    flags: ACC_PUBLIC

  public TestJvm();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: aload_0
         5: ldc           #2                  // String NotStaticStr
         7: putfield      #3                  // Field str:Ljava/lang/String;
        10: return
      LineNumberTable:
        line 1: 0
        line 2: 4
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      11     0  this   LTestJvm;
}
SourceFile: "TestJvm.java"
```