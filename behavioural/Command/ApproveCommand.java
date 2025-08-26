public class ApproveCommand implements Command {
    private Manager manager;
    private String document;

    public ApproveCommand(Manager manager, String document) {
        this.manager = manager;
        this.document = document;
    }

    @Override
    public void execute() {
        manager.approve(document);
    }
}
