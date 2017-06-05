package create.abstractFactory.process;

import create.abstractFactory.material.MailSender;
import create.abstractFactory.material.Sender;

public class SendMailFactory implements Provider {  
    
    @Override  
    public Sender produce(){  
        return new MailSender();  
    }  
}  