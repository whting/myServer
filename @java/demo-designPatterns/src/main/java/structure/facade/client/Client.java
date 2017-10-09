package structure.facade.client;

import structure.facade.process.Computer;

public class Client {  
  
    public static void main(String[] args) {  
        Computer computer = new Computer();  
        computer.startup();  
        computer.shutdown();  
    }  
}  