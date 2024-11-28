package decorator;

public abstract class BaseNotifierDecorator implements InterfaceNotifier {

    private final InterfaceNotifier wrapped;
    protected final DatabaseService databaseService;

    BaseNotifierDecorator(InterfaceNotifier wrapped) {
        this.wrapped = wrapped;
        databaseService = new DatabaseService();
    }

    @Override
    public void send(String msg) {
        wrapped.send(msg);
    }

    @Override
    public String getUsername() {
        return wrapped.getUsername();
    }

}
