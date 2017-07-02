
```
G:\liuxiang_code_git\myServer\@jvm\demo-jvm\target\classes>javap -v -p -s -sysinfo -constants SimpleClass.class
Classfile /G:/liuxiang_code_git/myServer/@jvm/demo-jvm/target/classes/SimpleClass.class
  Last modified 2017-7-2; size 480 bytes
  MD5 checksum c6fb86987cb1c85698d2acc38bd184dd
  Compiled from "SimpleClass.java"
public class SimpleClass
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #6.#17         // java/lang/Object."<init>":()V
   #2 = Fieldref           #18.#19        // java/lang/System.out:Ljava/io/PrintStream;
   #3 = String             #20            // Hello
   #4 = Methodref          #21.#22        // java/io/PrintStream.println:(Ljava/lang/String;)V
   #5 = Class              #23            // SimpleClass
   #6 = Class              #24            // java/lang/Object
   #7 = Utf8               <init>
   #8 = Utf8               ()V
   #9 = Utf8               Code
  #10 = Utf8               LineNumberTable
  #11 = Utf8               LocalVariableTable
  #12 = Utf8               this
  #13 = Utf8               LSimpleClass;
  #14 = Utf8               sayHello
  #15 = Utf8               SourceFile
  #16 = Utf8               SimpleClass.java
  #17 = NameAndType        #7:#8          // "<init>":()V
  #18 = Class              #25            // java/lang/System
  #19 = NameAndType        #26:#27        // out:Ljava/io/PrintStream;
  #20 = Utf8               Hello
  #21 = Class              #28            // java/io/PrintStream
  #22 = NameAndType        #29:#30        // println:(Ljava/lang/String;)V
  #23 = Utf8               SimpleClass
  #24 = Utf8               java/lang/Object
  #25 = Utf8               java/lang/System
  #26 = Utf8               out
  #27 = Utf8               Ljava/io/PrintStream;
  #28 = Utf8               java/io/PrintStream
  #29 = Utf8               println
  #30 = Utf8               (Ljava/lang/String;)V
{
  public SimpleClass();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 2: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   LSimpleClass;

  public void sayHello();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=1, args_size=1
         0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         3: ldc           #3                  // String Hello
         5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         8: return
      LineNumberTable:
        line 4: 0
        line 5: 8
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       9     0  this   LSimpleClass;
}
SourceFile: "SimpleClass.java"
```

-
```
常量池：提供了通常由符号表提供的相同信息
    Integer	4 字节常量
    Long	8 字节常量
    Float	4 字节常量
    Double	8 字节常量
    String	字符串常量指向常量池的另外一个包含真正字节 Utf8 编码的实体
    Utf8	Utf8 编码的字符序列字节流
    Class	一个 Class 常量，指向常量池的另一个 Utf8 实体，这个实体包含了符合 JVM 内部格式的类的全名（动态链接过程需要用到）
    NameAndType	冒号（:）分隔的一组值，这些值都指向常量池中的其它实体。第一个值（“:”之前的）指向一个 Utf8 字符串实体，它是一个方法名或者字段名。第二个值指向表示类型的 Utf8 实体。对于字段类型，这个值是类的全名，对于方法类型，这个值是每个参数类型类的类全名的列表。
    Fieldref, Methodref, InterfaceMethodref	点号（.）分隔的一组值，每个值都指向常量池中的其它的实体。第一个值（“.”号之前的）指向类实体，第二个值指向 NameAndType 实体。
方法：每一个方法包含四个区域，
    descriptor: ()V 描述,访问
    flags: ACC_PUBLIC 作用域
    Code: 字节码
        LineNumberTable 行对应的字节码信息
        LocalVariableTable 所有栈帧中的局部变量
```