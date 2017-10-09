
public class Enum_demo {

    enum Color {
        RED, GREEN, BLANK, YELLOW
    }

    enum Signal {
        GREEN, YELLOW, RED
    }

    enum WeekDay {

        //枚举对象必须放在最前面，匿名内部类的创建可以带参数，必须实现父类的抽象方法
        MON(1) {
            public WeekDay next() {
                return SUN;
            }
        },

        SUN(2) {
            public WeekDay next() {
                return MON;
            }
        };

        private int num;

        //枚举的构造函数是默认为private的，可以带参数
        WeekDay(int num) {
            this.num = num;
        }

        public abstract WeekDay next();
    }

    enum ErrorCodeEn {
        OK(0, "成功"),
        ERROR_A(100, "错误A"),
        ERROR_B(200, "错误B");

        ErrorCodeEn(int number, String description) {
            this.code = number;
            this.description = description;
        }

        private int code;
        private String description;

        public int getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }

        public static void main(String args[]) { // 静态方法
            System.out.println(ERROR_A + ":" + ERROR_A.code + ":" + ERROR_A.getDescription());
            for (ErrorCodeEn s : ErrorCodeEn.values()) {
                System.out.println("code: " + s.getCode() + ", description: " + s.getDescription());
            }
        }
    }

    enum Singleton6 {
        INSTANCE;

        public String getInfo(String s) {
            s = "hello " + s;
            System.out.println(s);
            return s;
        }

        public static void main(String[] args) {
            System.out.println(Singleton6.INSTANCE.getInfo("aa"));// 枚举单例
        }

        /**
         * 无偿地提供了序列化机制，绝对防止对此实例化，即使是在面对复杂的序列化或者反射攻击的时候。
         * 虽然这中方法还没有广泛采用，但是单元素的枚举类型已经成为实现Singleton的最佳方法。
         */
    }

    /******************************************************/

    public class TrafficLight {
        Signal color = Signal.RED;

        public void change() {
            switch (color) {
                case RED:
                    color = Signal.GREEN;
                    break;
                case YELLOW:
                    color = Signal.RED;
                    break;
                case GREEN:
                    color = Signal.YELLOW;
                    break;
            }
        }
    }

    public static void weekDay() {
        System.out.println(WeekDay.SUN.num);

        //使用方法，跟一般的对象是一模一样的
        WeekDay w = WeekDay.SUN;
        //直接打印枚举对象实际上是调用了toString
        System.out.println(WeekDay.SUN);// MON
        System.out.println(w);// MON
        //打印枚举的名字，实际上打印类的简短的名字w.getClass().getSimpleName()
        System.out.println(w.name());// MON
        //打印枚举对象在枚举中的位置，0开始算
        System.out.println(w.ordinal());
        //通过字符串去或者获取（构造）枚举对象
        System.out.println(WeekDay.valueOf("SUN"));

        System.out.println("--------------");
        //获取枚举类的所有对象，通过数组的方式去遍历
        for (WeekDay value : WeekDay.values()) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
//        Enum_demo.weekDay();
//        System.out.println(Singleton6.INSTANCE.getInfo("aa"));// 枚举单例
    }
}

/**
 * 主题：Java 枚举7常见种用法
 * http://www.tuicool.com/articles/3aem6n
 * <p>
 * Java 枚举用法详解 - 静默虚空 - 博客园
 * http://www.cnblogs.com/jingmoxukong/p/6098351.html
 */
