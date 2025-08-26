public class ChatbotHandler extends SupportHandler {
    @Override
    public void handleRequest(String query) {
        if (query.contains("password") || query.contains("FAQ")) {
            System.out.println("Chatbot: I can help you with resetting your password or FAQs.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(query);
        }
    }
}
