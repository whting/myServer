package doings.strategy.client;

import doings.strategy.material.ICalculator;
import doings.strategy.material.Plus;

public class Client {  
  
    public static void main(String[] args) {  
        String exp = "2+8";  
        ICalculator cal = new Plus();  
        int result = cal.calculate(exp);  
        System.out.println(result);  
    }  
}  