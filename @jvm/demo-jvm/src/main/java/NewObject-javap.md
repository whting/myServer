
```
G:\liuxiang_code_git\myServer\@jvm\demo-jvm\target\classes>javap -v -p -s NewObject.class
Classfile /G:/liuxiang_code_git/myServer/@jvm/demo-jvm/target/classes/NewObject.class
  Last modified 2017-7-2; size 419 bytes
  MD5 checksum 39795e2c8582ff13ec97a9ba79cdc489
  Compiled from "NewObject.java"
public class NewObject
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #2.#19         // java/lang/Object."<init>":()V
   #2 = Class              #20            // java/lang/Object
   #3 = Class              #21            // NewObject
   #4 = Utf8               <init>
   #5 = Utf8               ()V
   #6 = Utf8               Code
   #7 = Utf8               LineNumberTable
   #8 = Utf8               LocalVariableTable
   #9 = Utf8               this
  #10 = Utf8               LNewObject;
  #11 = Utf8               main
  #12 = Utf8               ([Ljava/lang/String;)V
  #13 = Utf8               args
  #14 = Utf8               [Ljava/lang/String;
  #15 = Utf8               foo
  #16 = Utf8               Ljava/lang/Object;
  #17 = Utf8               SourceFile
  #18 = Utf8               NewObject.java
  #19 = NameAndType        #4:#5          // "<init>":()V
  #20 = Utf8               java/lang/Object
  #21 = Utf8               NewObject
{
  public NewObject();
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
            0       5     0  this   LNewObject;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=2, args_size=1
         0: new           #2                  // class java/lang/Object
         3: dup
         4: invokespecial #1                  // Method java/lang/Object."<init>":()V
         7: astore_1
         8: return
      LineNumberTable:
        line 3: 0
        line 4: 8
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       9     0  args   [Ljava/lang/String;
            8       1     1   foo   Ljava/lang/Object;
}
SourceFile: "NewObject.java"
```