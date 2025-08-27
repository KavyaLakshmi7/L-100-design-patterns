# 🏷️ Mediator Pattern - Auction System Example

## 📌 Overview
The **Mediator Pattern** defines an object that encapsulates how a set of objects interact.  
It promotes **loose coupling** by preventing direct communication between objects, forcing them to communicate through a mediator.

In this example, we simulate an **auction system** where multiple buyers place bids through an `AuctionMediator`.  
The mediator coordinates the bidding process and notifies participants about updates.

---

## 🛠️ Components

1. **AuctionMediator (Interface)**  
   - Declares methods for placing bids and adding buyers.

2. **Auction (Concrete Mediator)**  
   - Maintains a list of buyers.  
   - Handles bids, determines the highest bidder, and notifies other buyers of outbids.  
   - Declares the winner at the end of the auction.

3. **Buyer (Colleague)**  
   - Represents a buyer participating in the auction.  
   - Places bids through the mediator.  
   - Receives notifications when outbid by another buyer.

4. **AuctionClient (Main / Client)**  
   - Creates buyers and starts the auction.  
   - Handles user input to simulate bidding.  
   - Declares the winner at the end.

---

## 📂 Class Diagram

```

AuctionMediator (interface)
├── placeBid(Buyer, amount)
└── addBuyer(Buyer)

Auction (implements AuctionMediator)
├── List<Buyer> buyers
├── Buyer highestBidder
├── int highestBid
├── placeBid()
├── addBuyer()
├── notifyBuyers()
└── declareWinner()

Buyer
├── String name
├── AuctionMediator mediator
├── placeBid()
├── outbidNotification()
└── getName()

AuctionClient (Client)
└── main()

```

---

## ▶️ How It Works

1. Buyers register with the auction mediator.  
2. A buyer places a bid → The mediator checks if it’s higher than the current highest bid.  
3. If valid, the mediator updates the highest bid and notifies all other buyers that they’ve been outbid.  
4. Once bidding ends, the mediator declares the winner.  

---

## 💻 Example Run

```

Enter number of buyers: 2
Enter name of buyer 1: Alice
Enter name of buyer 2: Bob

Auction started! Enter bids (type '0' to stop):
Enter buyer name: Alice
Enter bid amount: 100
Alice bids 100

Enter buyer name: Bob
Enter bid amount: 150
Bob bids 150
Alice is notified: Bob placed higher bid of 150

Enter buyer name: 0
Auction winner is Bob with bid 150

````

---

## ✅ Key Benefits
- **Loose coupling** – Buyers do not communicate directly, only via mediator.  
- **Centralized control** – Mediator manages bidding rules and notifications.  
- **Scalability** – New buyers can be added easily without changing others.  

---

## 📖 Real-World Use Cases
- Auction or Bidding systems  
- Chat rooms (mediator between participants)  
- Air traffic control (mediator between planes)  
- Online marketplaces coordinating buyers and sellers  

---

## 🚀 How to Run
1. Compile all `.java` files:  
   ```bash
   javac *.java
````

2. Run the program:

   ```bash
   java AuctionClient
   ```