```
public class TestJvm {
    public static void stFun(){}
}
```

```
G:\liuxiang_code_git\myServer\@jvm\demo-jvm\target\classes>javap -v TestJvm.class
Classfile /G:/liuxiang_code_git/myServer/@jvm/demo-jvm/target/classes/TestJvm.class
  Last modified 2017-7-2; size 293 bytes
  MD5 checksum 25e20cf6dd91ccc6ff0bdd5dbc86794b
  Compiled from "TestJvm.java"
public class TestJvm
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #3.#14         // java/lang/Object."<init>":()V
   #2 = Class              #15            // TestJvm
   #3 = Class              #16            // java/lang/Object
   #4 = Utf8               <init>
   #5 = Utf8               ()V
   #6 = Utf8               Code
   #7 = Utf8               LineNumberTable
   #8 = Utf8               LocalVariableTable
   #9 = Utf8               this
  #10 = Utf8               LTestJvm;
  #11 = Utf8               stFun
  #12 = Utf8               SourceFile
  #13 = Utf8               TestJvm.java
  #14 = NameAndType        #4:#5          // "<init>":()V
  #15 = Utf8               TestJvm
  #16 = Utf8               java/lang/Object
{
  public TestJvm();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 1: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   LTestJvm;

  public static void stFun();
    descriptor: ()V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=0, locals=0, args_size=0
         0: return
      LineNumberTable:
        line 2: 0
}
SourceFile: "TestJvm.java"

```