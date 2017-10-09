`Java 反射`
http://www.importnew.com/17616.html

# 用法
- className初始化类实例,可用于动态任务
- 用已经实例化的Object.class进行动态方法或参数的调用。动态代理
- 方法名的逻辑处理。对find开头的方法进行事务处理
- 使用代理(或aop)来访问自定义注解,已达到能力封装效果

# 高效反射包
- ReflectASM
执行时会生成一个存取类来 set/get 字段，访问方法或创建实例
避免了访问原始类型因自动装箱而产生的问题

---
# 序列化
Java对象转换为字节序列的过程就称为对象的序列化.
将字节序列恢复成Java对象的过程称为对象的反序列化.
只有实现了 serializable和Externalizable接口的类的对象才能被序列化

- 序列化   new ObjectOutputStream(new FileOutputStream("my.out"));
- 反序列化 new ObjectInputStream(new FileInputStream("my.out")); 

序列化会忽略静态变量，即序列化不保存静态变量的状态
静态成员属于类级别的，所以不能序列化。即 序列化的是对象的状态不是类的状态。这里的不能序列化的意思，是序列化信息中不包含这个静态成员域

---
`整理几个概念：反射、序列化`
http://www.cnblogs.com/lzb1991/p/6510273.html

`Java 序列化Serializable详解（附详细例子） - 飞飞飞飞飞 - 博客园`
http://www.cnblogs.com/gtaxmjld/p/4866931.html

`Java反射在JVM的实现`
http://blog.csdn.net/jianghuxiaojin/article/details/56670492

`Java 下高效的反射工具包 ReflectASM 使用例解   隔叶黄莺 Unmi Blog`
http://www.tuicool.com/articles/yUbU32