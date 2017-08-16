package structure.decorator.demo2;

public class XiaoGuang {

    public static void main(String[] args) {

        Drink coke = new Coke();
        System.out.println(coke.make());

        Drink iceCoke = new Ice(new Coke());
        System.out.println(iceCoke.make());
    }
}