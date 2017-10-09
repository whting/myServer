```
public class TestJvm {
    public static String str = "staticStr";
}
```

```
G:\liuxiang_code_git\myServer\@jvm\demo-jvm\target\classes>javap -v TestJvm.class
Classfile /G:/liuxiang_code_git/myServer/@jvm/demo-jvm/target/classes/TestJvm.class
  Last modified 2017-7-2; size 361 bytes
  MD5 checksum 80be07a95b5917d5494fa756c0d6e82b
  Compiled from "TestJvm.java"
public class TestJvm
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #5.#18         // java/lang/Object."<init>":()V
   #2 = String             #19            // staticStr
   #3 = Fieldref           #4.#20         // TestJvm.str:Ljava/lang/String;
   #4 = Class              #21            // TestJvm
   #5 = Class              #22            // java/lang/Object
   #6 = Utf8               str
   #7 = Utf8               Ljava/lang/String;
   #8 = Utf8               <init>
   #9 = Utf8               ()V
  #10 = Utf8               Code
  #11 = Utf8               LineNumberTable
  #12 = Utf8               LocalVariableTable
  #13 = Utf8               this
  #14 = Utf8               LTestJvm;
  #15 = Utf8               <clinit>
  #16 = Utf8               SourceFile
  #17 = Utf8               TestJvm.java
  #18 = NameAndType        #8:#9          // "<init>":()V
  #19 = Utf8               staticStr
  #20 = NameAndType        #6:#7          // str:Ljava/lang/String;
  #21 = Utf8               TestJvm
  #22 = Utf8               java/lang/Object
{
  public static java.lang.String str;
    descriptor: Ljava/lang/String;
    flags: ACC_PUBLIC, ACC_STATIC

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

  static {};
    descriptor: ()V
    flags: ACC_STATIC
    Code:
      stack=1, locals=0, args_size=0
         0: ldc           #2                  // String staticStr
         2: putstatic     #3                  // Field str:Ljava/lang/String;
         5: return
      LineNumberTable:
        line 2: 0
}
SourceFile: "TestJvm.java"
```