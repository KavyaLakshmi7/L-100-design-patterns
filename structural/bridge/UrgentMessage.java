public class UrgentMessage extends Message {
    public UrgentMessage(MessageSender sender) {
        super(sender);
    }

    @Override
    public void send(String text) {
        sender.sendMessage("Urgent: " + text);
    }
}
