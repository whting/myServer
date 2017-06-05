# 特性
- Lambda 箭头调用
- interface default 为接口增加了默认函数实体,且不要求继承实现
- @FunctionalInterface lambda的默认接口方法,供快速实现
    - 该注解只能标记在"有且仅有一个抽象方法"的接口上
- twoColons::function realize lambda的快捷调用(封装调用)
- optional 可选项
    - Optionals是没有函数的接口，取而代之的是防止 NullPointerException 
- builtInFunction 内建函数
    - Predicate断言,Function功能函数,Consumer,Comparator比较,optional,stream


---
# 新特性(教程)
http://www.runoob.com/java/java8-new-features.html
- Java8 新增了非常多的特性，我们主要讨论以下几个：
- Lambda 表达式 − Lambda允许把函数作为一个方法的参数（函数作为参数传递进方法中。
- 方法引用 − 方法引用提供了非常有用的语法，可以直接引用已有Java类或对象（实例）的方法或构造器。与lambda联合使用，方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
- 默认方法 − 默认方法就是一个在接口里面有了一个实现的方法。
- 新工具 − 新的编译工具，如：Nashorn引擎 jjs、 类依赖分析器jdeps。
- Stream API −新添加的Stream API（java.util.stream） 把真正的函数式编程风格引入到Java中。
- Date Time API − 加强对日期与时间的处理。
- Optional 类 − Optional 类已经成为 Java 8 类库的一部分，用来解决空指针异常。
- Nashorn, JavaScript 引擎 − Java 8提供了一个新的Nashorn javascript引擎，它允许我们在JVM上运行特定的javascript应用。

---
# 推酷-java8文章搜索(需要注册账号)
http://www.tuicool.com/search?kw=java+8&t=1

# 另一个java8教程:
https://github.com/winterbe/java8-tutorial.git

# 官网API
http://docs.oracle.com/javase/8/docs/api/
