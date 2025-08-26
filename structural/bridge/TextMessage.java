public class TextMessage extends Message {
    public TextMessage(MessageSender sender) {
        super(sender);
    }

    @Override
    public void send(String text) {
        sender.sendMessage("Text Message: " + text);
    }
}
