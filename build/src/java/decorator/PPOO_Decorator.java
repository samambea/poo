package decorator;

public class PPOO_Decorator {

    public static void main(String[] args) {

        InterfaceNotifier notifyMail = new Notifier("cliente");
        notifyMail.send("Cadastro efetuado");
        
        System.out.println("==========================================");

        InterfaceNotifier notifyAll = new FacebookDecorator(new WhatsAppDecorator(new TelegramDecorator(new Notifier("cliente"))));
        notifyAll.send("Cadastro efetuado!!!");

        System.out.println("==========================================");

        InterfaceNotifier notifyWAppMail = new WhatsAppDecorator(new Notifier("cliente"));
        notifyWAppMail.send("Cadastro efetuado!!!");

        System.out.println("==========================================");

        InterfaceNotifier notifyTgmFbMail = new TelegramDecorator(new FacebookDecorator(new Notifier("cliente")));
        notifyTgmFbMail.send("Cadastro efetuado!!!");

    }
}