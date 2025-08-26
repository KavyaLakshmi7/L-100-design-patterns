public interface AuctionMediator {
    void placeBid(Buyer buyer, int amount);
    void addBuyer(Buyer buyer);
}
