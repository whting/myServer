```
public class TestJvm {

    public static void main(String[] args) {
//        int i = 998;
        String s1 = "hello";
        String s2 = "hello";
    }
}
```

```
G:\liuxiang_code_git\myServer\@jvm\demo-jvm\target\classes>javap -v TestJvm.class
Classfile /G:/liuxiang_code_git/myServer/@jvm/demo-jvm/target/classes/TestJvm.class
  Last modified 2017-7-2; size 440 bytes
  MD5 checksum c732babf69bf7bb7012d9b81a40544b7
  Compiled from "TestJvm.java"
public class TestJvm
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #4.#21         // java/lang/Object."<init>":()V
   #2 = String             #22            // hello
   #3 = Class              #23            // TestJvm
   #4 = Class              #24            // java/lang/Object
   #5 = Utf8               <init>
   #6 = Utf8               ()V
   #7 = Utf8               Code
   #8 = Utf8               LineNumberTable
   #9 = Utf8               LocalVariableTable
  #10 = Utf8               this
  #11 = Utf8               LTestJvm;
  #12 = Utf8               main
  #13 = Utf8               ([Ljava/lang/String;)V
  #14 = Utf8               args
  #15 = Utf8               [Ljava/lang/String;
  #16 = Utf8               s1
  #17 = Utf8               Ljava/lang/String;
  #18 = Utf8               s2
  #19 = Utf8               SourceFile
  #20 = Utf8               TestJvm.java
  #21 = NameAndType        #5:#6          // "<init>":()V
  #22 = Utf8               hello
  #23 = Utf8               TestJvm
  #24 = Utf8               java/lang/Object
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

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=1, locals=3, args_size=1
         0: ldc           #2                  // String hello
         2: astore_1
         3: ldc           #2                  // String hello
         5: astore_2
         6: return
      LineNumberTable:
        line 5: 0
        line 6: 3
        line 7: 6
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       7     0  args   [Ljava/lang/String;
            3       4     1    s1   Ljava/lang/String;
            6       1     2    s2   Ljava/lang/String;
}
SourceFile: "TestJvm.java"
```