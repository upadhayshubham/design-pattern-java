package BehavioralPatterns.strategyPattern;

public class Order {
    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int cost) {
        this.totalCost += cost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
    }

    private int totalCost = 0;
    private boolean isClosed;

    public void processOrder(PayStrategy payStrategy) {
        payStrategy.collectPaymentDetails();
    }
}
