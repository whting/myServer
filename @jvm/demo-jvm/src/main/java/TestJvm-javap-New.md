```
public class TestJvm {
    Object obj = new Object();
}
```
```
G:\liuxiang_code_git\myServer\@jvm\demo-jvm\target\classes>javap -v TestJvm.class
Classfile /G:/liuxiang_code_git/myServer/@jvm/demo-jvm/target/classes/TestJvm.class
  Last modified 2017-7-2; size 306 bytes
  MD5 checksum 5f3ff9e941aba6cb724b8ae07cfa6e4a
  Compiled from "TestJvm.java"
public class TestJvm
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #2.#16         // java/lang/Object."<init>":()V
   #2 = Class              #17            // java/lang/Object
   #3 = Fieldref           #4.#18         // TestJvm.obj:Ljava/lang/Object;
   #4 = Class              #19            // TestJvm
   #5 = Utf8               obj
   #6 = Utf8               Ljava/lang/Object;
   #7 = Utf8               <init>
   #8 = Utf8               ()V
   #9 = Utf8               Code
  #10 = Utf8               LineNumberTable
  #11 = Utf8               LocalVariableTable
  #12 = Utf8               this
  #13 = Utf8               LTestJvm;
  #14 = Utf8               SourceFile
  #15 = Utf8               TestJvm.java
  #16 = NameAndType        #7:#8          // "<init>":()V
  #17 = Utf8               java/lang/Object
  #18 = NameAndType        #5:#6          // obj:Ljava/lang/Object;
  #19 = Utf8               TestJvm
{
  java.lang.Object obj;
    descriptor: Ljava/lang/Object;
    flags:

  public TestJvm();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=3, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: aload_0
         5: new           #2                  // class java/lang/Object
         8: dup
         9: invokespecial #1                  // Method java/lang/Object."<init>":()V
        12: putfield      #3                  // Field obj:Ljava/lang/Object;
        15: return
      LineNumberTable:
        line 1: 0
        line 2: 4
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      16     0  this   LTestJvm;
}
SourceFile: "TestJvm.java"
```