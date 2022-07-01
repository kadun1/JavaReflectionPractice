package p12auction;

import java.io.Serializable;
import java.util.Locale;

public abstract class P12Bid  implements Serializable {

    protected int price;
    protected String bidderName;

    public int getPrice() {
        return price;
    }

    public String getBidderName() {
        return bidderName;
    }

    public static Builder builder() { return new Builder(); }

    @Override
    public String toString() {
        return "P12Bid{" +
                "price=" + price +
                ", bidderName='" + bidderName + '\'' +
                '}';
    }

    public static class Builder {
        private int price;
        private String bidderName;

        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Builder setBidderName(String bidderName) {
            this.bidderName = bidderName;
            return this;
        }

        public P12Bid build() { return new Builder.BidImpl(); }

        private class BidImpl extends P12Bid {

            private BidImpl(){
                super.price = Builder.this.price;
                super.bidderName = Builder.this.bidderName;
            }

        }
    }
}
