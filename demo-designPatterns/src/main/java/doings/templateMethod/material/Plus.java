package doings.templateMethod.material;

import doings.templateMethod.process.AbstractCalculator;

public class Plus extends AbstractCalculator {  
  
    @Override  
    public int calculate(int num1,int num2) {  
        return num1 + num2;  
    }  
}  