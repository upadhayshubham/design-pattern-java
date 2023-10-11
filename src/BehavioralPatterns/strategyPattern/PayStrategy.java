package BehavioralPatterns.strategyPattern;

public interface PayStrategy {
    boolean pay(int amount);
    void collectPaymentDetails();
}
