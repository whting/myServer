/**
 * 我们声明一个包级别的函数main，它返回Unit并带有
 * 一个字符串数组作为参数。 请注意，分号是可选的。
 */
fun main(args: Array<String>) {
    println("hello world");
}

/**
 * 参数获取,读取数组
 */
//fun main(args: Array<String>) {
//    if (args.size == 0) {
//        println("Please provide a name as a command-line argument")
//        return
//    }
//    println("Hello, ${args[0]}!")
//}

/**
 * 遍历list
 */
//fun main(args: Array<String>) {
//    val array = arrayListOf<String>()
//    array.add("aaa")
//    array.add("bbb")
//    array.add("ccc")
//
//    for (item in array) {
//        println("item:$item")
//    }
//}

/**
 * 三元表达式
 */
//fun main(args: Array<String>) {
//    var args = arrayListOf<String>();
//    args.add("CN");
//    var language = if (args.size == 0) "EN" else args[0];
//    var say = when(language){
//        "EN" -> "Hello!"
//        "CN" -> "你好!"
//        else -> "Sorry, I can't greet you in $language yet"
//    }
//    println(say);
//}

/**
 * 类声明,调用
 */
//class Greeter(var name: String) {
//    fun greet() {
//        println("hello,$name");
//    }
//}
//
//fun main(args: Array<String>) {
//    Greeter("world").greet();
//}

/**
 * 条件表达式
 */
//fun main(args: Array<String>) {
//    var args = arrayListOf<String>();
//    args.add("10");
//    args.add("20");
//    println(max(args[0].toInt(), args[1].toInt()))
//}
//
//fun max(a: Int, b: Int) = if (a > b) a else b