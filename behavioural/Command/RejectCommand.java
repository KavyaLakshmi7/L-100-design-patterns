public class RejectCommand implements Command {
    private Manager manager;
    private String document;

    public RejectCommand(Manager manager, String document) {
        this.manager = manager;
        this.document = document;
    }

    @Override
    public void execute() {
        manager.reject(document);
    }
}
