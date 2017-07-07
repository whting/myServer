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

class SingleTon_Test {

    public static void main(String[] args) {
        System.out.println("count =" + SingleTon.count);// 1 因无赋值操作,所以保持了`方法区-运行时常量池`中的数值
        System.out.println("count1=" + SingleTon.count1);// 171 count1已经在类初始化前将数值放入了`方法区-运行时常量池`,所以感觉无恙
        System.out.println("count2=" + SingleTon.count2);// 188 在已经完成了类初始化后,再将188赋值`方法区-运行时常量池`,将会覆盖原值
    }
}

/**
 * java类加载时机与过程 - 博客频道 - CSDN.NET
 * http://blog.csdn.net/liang_70121385/article/details/52496028
 */