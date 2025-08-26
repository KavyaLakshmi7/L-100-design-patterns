import java.util.ArrayList;
import java.util.List;

public class Auction implements AuctionMediator {
    private List<Buyer> buyers = new ArrayList<>();
    private Buyer highestBidder;
    private int highestBid = 0;

    @Override
    public void placeBid(Buyer buyer, int amount) {
        if (amount > highestBid) {
            highestBid = amount;
            highestBidder = buyer;
            notifyBuyers(buyer, amount);
        } else {
            System.out.println(buyer.getName() + " bid " + amount + " which is too low.");
        }
    }

    @Override
    public void addBuyer(Buyer buyer) {
        buyers.add(buyer);
    }

    private void notifyBuyers(Buyer buyer, int amount) {
        for (Buyer b : buyers) {
            if (b != buyer) {
                b.outbidNotification(buyer.getName(), amount);
            }
        }
    }

    public void declareWinner() {
        if (highestBidder != null) {
            System.out.println("Auction winner is " + highestBidder.getName() + " with bid " + highestBid);
        } else {
            System.out.println("No bids placed. No winner.");
        }
    }
}
