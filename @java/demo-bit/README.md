`笔记：二进制基础》3-1 位运算》异或运算^,效率最高的变量交换`
http://www.imooc.com/learn/195 

`在UTF-8中，一个汉字为什么需要三个字节？`
http://blog.csdn.net/crslee/article/details/52041016

`1个汉字在UTF-8编码占3个字节 - 胜强 - 博客园`
http://www.cnblogs.com/wincai/p/6012602.html
```
打开"记事本"程序Notepad.exe，新建一个文本文件，内容就是一个"严"字，依次采用ANSI，Unicode，Unicode big endian 和 UTF-8编码方式保存。
然后，用文本编辑软件UltraEdit中的"十六进制功能"，观察该文件的内部编码方式。
1）ANSI：文件的编码就是两个字节"D1 CF"，这正是"严"的GB2312编码，这也暗示GB2312是采用大头方式存储的。 
2）Unicode：编码是四个字节"FF FE 25 4E"，其中"FF FE"表明是小头方式存储，真正的编码是4E25。
3）Unicode big endian：编码是四个字节"FE FF 4E 25"，其中"FE FF"表明是大头方式存储。
4）UTF-8：编码是六个字节"EF BB BF E4 B8 A5"，前三个字节"EF BB BF"表示这是UTF-8编码，后三个"E4B8A5"就是"严"的具体编码，它的存储顺序与编码顺序是一致的。
```

`文件的编码-慕课网``联-联通-联想`/`慕课ABC`
http://www.imooc.com/video/1832

`谈谈字符编码那些事 - 推酷` `联通`
http://www.tuicool.com/articles/zABrUbb