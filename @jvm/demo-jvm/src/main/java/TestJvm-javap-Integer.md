```
public class TestJvm {

    public static void main(String[] args) {
        Integer i = 998;
    }
}
```

```
G:\liuxiang_code_git\myServer\@jvm\demo-jvm\target\classes>javap -v TestJvm.class
Classfile /G:/liuxiang_code_git/myServer/@jvm/demo-jvm/target/classes/TestJvm.class
  Last modified 2017-7-2; size 479 bytes
  MD5 checksum c13252f345ee252856e41cd8145a3e53
  Compiled from "TestJvm.java"
public class TestJvm
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #4.#20         // java/lang/Object."<init>":()V
   #2 = Methodref          #21.#22        // java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
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
  #16 = Utf8               i
  #17 = Utf8               Ljava/lang/Integer;
  #18 = Utf8               SourceFile
  #19 = Utf8               TestJvm.java
  #20 = NameAndType        #5:#6          // "<init>":()V
  #21 = Class              #25            // java/lang/Integer
  #22 = NameAndType        #26:#27        // valueOf:(I)Ljava/lang/Integer;
  #23 = Utf8               TestJvm
  #24 = Utf8               java/lang/Object
  #25 = Utf8               java/lang/Integer
  #26 = Utf8               valueOf
  #27 = Utf8               (I)Ljava/lang/Integer;
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
      stack=1, locals=2, args_size=1
         0: sipush        998
         3: invokestatic  #2                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
         6: astore_1
         7: return
      LineNumberTable:
        line 4: 0
        line 5: 7
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       8     0  args   [Ljava/lang/String;
            7       1     1     i   Ljava/lang/Integer;
}
SourceFile: "TestJvm.java"
```