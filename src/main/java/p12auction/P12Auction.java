package p12auction;

import java.io.Serializable;
import java.util.*;

public class P12Auction implements Serializable {
    private final List<P12Bid> bids = new ArrayList<>();

    private transient volatile boolean isAuctionStarted;

    //Methods
    public synchronized void addBid(P12Bid bid) { this.bids.add(bid); }

    public synchronized List<P12Bid> getAllBids() { return Collections.unmodifiableList(bids); }

    public synchronized Optional<P12Bid> getHighestBid() {
        return bids.stream().max(
                Comparator.comparing(P12Bid::getPrice));
    }

    public void startAuction() { this.isAuctionStarted = true; }
    public void stopAuction() { this.isAuctionStarted = false; }
    public boolean isAuctionRunning() { return isAuctionStarted; }
}
