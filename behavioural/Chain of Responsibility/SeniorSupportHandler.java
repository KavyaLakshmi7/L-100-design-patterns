public class SeniorSupportHandler extends SupportHandler {
    @Override
    public void handleRequest(String query) {
        if (query.contains("technical") || query.contains("error")) {
            System.out.println("Senior Support: I will resolve your technical issue.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(query);
        }
    }
}
