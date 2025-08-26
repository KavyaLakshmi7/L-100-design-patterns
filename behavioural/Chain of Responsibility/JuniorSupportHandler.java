public class JuniorSupportHandler extends SupportHandler {
    @Override
    public void handleRequest(String query) {
        if (query.contains("billing")) {
            System.out.println("Junior Support: I can help you with billing issues.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(query);
        }
    }
}
