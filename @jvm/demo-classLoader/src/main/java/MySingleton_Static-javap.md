```
class MySingleton_Static {

    // 初始化时机：当任意static被被访问时,会初始化实例(建议initInstall)。否则将在getInstall访问时才创建(非饿加载)
    public static int initInstall = 1;

    /* 考虑类加载机制的初始化条件(被new或内部static被访问),所以启动时并不会实例化*/
    private static MySingleton_Static mySingleton = new MySingleton_Static();

    private MySingleton_Static() {
        System.out.println("Loader");// 监控实例化时机
    }

    public static MySingleton_Static getInstall() {
        return mySingleton;
    }
}
```

```
G:\liuxiang_code_git\myServer\@jvm\demo-classLoader\target\classes>javap -v MySingleton_Static.class
Classfile /G:/liuxiang_code_git/myServer/@jvm/demo-classLoader/target/classes/MySingleton_Static.class
  Last modified 2017-7-7; size 659 bytes
  MD5 checksum be26f05e93cf3368bd2b45ab4cae609c
  Compiled from "MySingleton_Static.java"
class MySingleton_Static
  minor version: 0
  major version: 52
  flags: ACC_SUPER
Constant pool:
   #1 = Methodref          #9.#25         // java/lang/Object."<init>":()V
   #2 = Fieldref           #26.#27        // java/lang/System.out:Ljava/io/PrintStream;
   #3 = String             #28            // Loader
   #4 = Methodref          #29.#30        // java/io/PrintStream.println:(Ljava/lang/String;)V
   #5 = Fieldref           #7.#31         // MySingleton_Static.mySingleton:LMySingleton_Static;
   #6 = Fieldref           #7.#32         // MySingleton_Static.initInstall:I
   #7 = Class              #33            // MySingleton_Static
   #8 = Methodref          #7.#25         // MySingleton_Static."<init>":()V
   #9 = Class              #34            // java/lang/Object
  #10 = Utf8               initInstall
  #11 = Utf8               I
  #12 = Utf8               mySingleton
  #13 = Utf8               LMySingleton_Static;
  #14 = Utf8               <init>
  #15 = Utf8               ()V
  #16 = Utf8               Code
  #17 = Utf8               LineNumberTable
  #18 = Utf8               LocalVariableTable
  #19 = Utf8               this
  #20 = Utf8               getInstall
  #21 = Utf8               ()LMySingleton_Static;
  #22 = Utf8               <clinit>
  #23 = Utf8               SourceFile
  #24 = Utf8               MySingleton_Static.java
  #25 = NameAndType        #14:#15        // "<init>":()V
  #26 = Class              #35            // java/lang/System
  #27 = NameAndType        #36:#37        // out:Ljava/io/PrintStream;
  #28 = Utf8               Loader
  #29 = Class              #38            // java/io/PrintStream
  #30 = NameAndType        #39:#40        // println:(Ljava/lang/String;)V
  #31 = NameAndType        #12:#13        // mySingleton:LMySingleton_Static;
  #32 = NameAndType        #10:#11        // initInstall:I
  #33 = Utf8               MySingleton_Static
  #34 = Utf8               java/lang/Object
  #35 = Utf8               java/lang/System
  #36 = Utf8               out
  #37 = Utf8               Ljava/io/PrintStream;
  #38 = Utf8               java/io/PrintStream
  #39 = Utf8               println
  #40 = Utf8               (Ljava/lang/String;)V
{
  public static int initInstall;
    descriptor: I
    flags: ACC_PUBLIC, ACC_STATIC

  public static MySingleton_Static getInstall();
    descriptor: ()LMySingleton_Static;
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=1, locals=0, args_size=0
         0: getstatic     #5                  // Field mySingleton:LMySingleton_Static;
         3: areturn
      LineNumberTable:
        line 14: 0

  static {};
    descriptor: ()V
    flags: ACC_STATIC
    Code:
      stack=2, locals=0, args_size=0
         0: iconst_1
         1: putstatic     #6                  // Field initInstall:I
         4: new           #7                  // class MySingleton_Static
         7: dup
         8: invokespecial #8                  // Method "<init>":()V
        11: putstatic     #5                  // Field mySingleton:LMySingleton_Static;
        14: return
      LineNumberTable:
        line 4: 0
        line 7: 4
}
SourceFile: "MySingleton_Static.java"
```