package decorator;

public class TelegramDecorator extends BaseNotifierDecorator {

    public TelegramDecorator(InterfaceNotifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        String phoneNbr = databaseService.getPhoneNbrFromUsername(getUsername());
        System.out.println("Sending " + msg + " by Telegram on " + phoneNbr);
    }
}
