```
public class SingleTon {

    public static int count1 = 170;// 在第5行(即类初始化)前,将数值加入`方法区-运行时常量池`

    private static SingleTon singleTon = new SingleTon();

    public static int count;// 此时虽然已经完成了初始化,但无赋值操作,将保持`方法区-运行时常量池`中的数值
    public static int count2 = 188;// 此时已经完成了类初始化,再将188赋值,将会覆盖原值

    private SingleTon() {
        count++;
        System.out.println(" count++; " + count);// 1
        count1++;
        System.out.println(" count1++; " + count1);// 171
        count2++;
        System.out.println(" count2++; " + count2);// 1(栈帧中的操作数栈,此时还在第5行,还未执行count2的赋值)
    }

    public static SingleTon getInstance() {
        return singleTon;
    }
}
```

```
G:\liuxiang_code_git\myServer\@jvm\demo-classLoader\target\classes>javap -v SingleTon.class
Classfile /G:/liuxiang_code_git/myServer/@jvm/demo-classLoader/target/classes/SingleTon.class
  Last modified 2017-7-7; size 1023 bytes
  MD5 checksum afb31d9e86dc5fe19907b4d4d78d38e9
  Compiled from "SingleTon.java"
public class SingleTon
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #18.#36        // java/lang/Object."<init>":()V
   #2 = Fieldref           #16.#37        // SingleTon.count:I
   #3 = Fieldref           #38.#39        // java/lang/System.out:Ljava/io/PrintStream;
   #4 = Class              #40            // java/lang/StringBuilder
   #5 = Methodref          #4.#36         // java/lang/StringBuilder."<init>":()V
   #6 = String             #41            //  count++;
   #7 = Methodref          #4.#42         // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   #8 = Methodref          #4.#43         // java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
   #9 = Methodref          #4.#44         // java/lang/StringBuilder.toString:()Ljava/lang/String;
  #10 = Methodref          #45.#46        // java/io/PrintStream.println:(Ljava/lang/String;)V
  #11 = Fieldref           #16.#47        // SingleTon.count1:I
  #12 = String             #48            //  count1++;
  #13 = Fieldref           #16.#49        // SingleTon.count2:I
  #14 = String             #50            //  count2++;
  #15 = Fieldref           #16.#51        // SingleTon.singleTon:LSingleTon;
  #16 = Class              #52            // SingleTon
  #17 = Methodref          #16.#36        // SingleTon."<init>":()V
  #18 = Class              #53            // java/lang/Object
  #19 = Utf8               count1
  #20 = Utf8               I
  #21 = Utf8               singleTon
  #22 = Utf8               LSingleTon;
  #23 = Utf8               count
  #24 = Utf8               count2
  #25 = Utf8               <init>
  #26 = Utf8               ()V
  #27 = Utf8               Code
  #28 = Utf8               LineNumberTable
  #29 = Utf8               LocalVariableTable
  #30 = Utf8               this
  #31 = Utf8               getInstance
  #32 = Utf8               ()LSingleTon;
  #33 = Utf8               <clinit>
  #34 = Utf8               SourceFile
  #35 = Utf8               SingleTon.java
  #36 = NameAndType        #25:#26        // "<init>":()V
  #37 = NameAndType        #23:#20        // count:I
  #38 = Class              #54            // java/lang/System
  #39 = NameAndType        #55:#56        // out:Ljava/io/PrintStream;
  #40 = Utf8               java/lang/StringBuilder
  #41 = Utf8                count++;
  #42 = NameAndType        #57:#58        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  #43 = NameAndType        #57:#59        // append:(I)Ljava/lang/StringBuilder;
  #44 = NameAndType        #60:#61        // toString:()Ljava/lang/String;
  #45 = Class              #62            // java/io/PrintStream
  #46 = NameAndType        #63:#64        // println:(Ljava/lang/String;)V
  #47 = NameAndType        #19:#20        // count1:I
  #48 = Utf8                count1++;
  #49 = NameAndType        #24:#20        // count2:I
  #50 = Utf8                count2++;
  #51 = NameAndType        #21:#22        // singleTon:LSingleTon;
  #52 = Utf8               SingleTon
  #53 = Utf8               java/lang/Object
  #54 = Utf8               java/lang/System
  #55 = Utf8               out
  #56 = Utf8               Ljava/io/PrintStream;
  #57 = Utf8               append
  #58 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
  #59 = Utf8               (I)Ljava/lang/StringBuilder;
  #60 = Utf8               toString
  #61 = Utf8               ()Ljava/lang/String;
  #62 = Utf8               java/io/PrintStream
  #63 = Utf8               println
  #64 = Utf8               (Ljava/lang/String;)V
{
  public static int count1;
    descriptor: I
    flags: ACC_PUBLIC, ACC_STATIC

  public static int count;
    descriptor: I
    flags: ACC_PUBLIC, ACC_STATIC

  public static int count2;
    descriptor: I
    flags: ACC_PUBLIC, ACC_STATIC

  public static SingleTon getInstance();
    descriptor: ()LSingleTon;
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=1, locals=0, args_size=0
         0: getstatic     #15                 // Field singleTon:LSingleTon;
         3: areturn
      LineNumberTable:
        line 20: 0

  static {};
    descriptor: ()V
    flags: ACC_STATIC
    Code:
      stack=2, locals=0, args_size=0
         0: sipush        170
         3: putstatic     #11                 // Field count1:I
         6: new           #16                 // class SingleTon
         9: dup
        10: invokespecial #17                 // Method "<init>":()V
        13: putstatic     #15                 // Field singleTon:LSingleTon;
        16: sipush        188
        19: putstatic     #13                 // Field count2:I
        22: return
      LineNumberTable:
        line 3: 0
        line 5: 6
        line 8: 16
}
SourceFile: "SingleTon.java"

```