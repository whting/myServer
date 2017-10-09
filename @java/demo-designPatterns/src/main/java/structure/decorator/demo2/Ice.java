package structure.decorator.demo2;

public class Ice extends Stuff {

    public Ice(Drink originalDrink) {
        super(originalDrink);
    }

    @Override
    String stuffName() {
        return "冰";
    }
}