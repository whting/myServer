public class SingleTon_new {


    public static int count1 = 170;// 在第5行(即类初始化)前,将数值加入`方法区-运行时常量池`
    public static int count;// 此时虽然已经完成了初始化,但无赋值操作,将保持`方法区-运行时常量池`中的数值
    public static int count2 = 188;// 此时已经完成了类初始化,再将188赋值,将会覆盖原值

    public SingleTon_new() {
        count++;
        System.out.println(" count++; " + count);// 1
        count1++;
        System.out.println(" count1++; " + count1);// 171
        count2++;
        System.out.println(" count2++; " + count2);// 189
    }
}

class SingleTon_new_Test {

    public static void main(String[] args) {
        SingleTon_new singleTon=new SingleTon_new();// 1,171,189 说明:在new Object的构造方法执行前,会先执行`static属性组成的static{}方法`
    }
}

/**
 * java类加载时机与过程 - 博客频道 - CSDN.NET
 * http://blog.csdn.net/liang_70121385/article/details/52496028
 */