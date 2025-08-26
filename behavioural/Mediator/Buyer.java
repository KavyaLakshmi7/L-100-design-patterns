public class Buyer {
    private String name;
    private AuctionMediator mediator;

    public Buyer(String name, AuctionMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        mediator.addBuyer(this);
    }

    public void placeBid(int amount) {
        System.out.println(name + " bids " + amount);
        mediator.placeBid(this, amount);
    }

    public void outbidNotification(String bidderName, int amount) {
        System.out.println(name + " is notified: " + bidderName + " placed higher bid of " + amount);
    }

    public String getName() {
        return name;
    }
}
