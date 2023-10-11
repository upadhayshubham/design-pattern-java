package BehavioralPatterns.strategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayByCreditCard implements PayStrategy{
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard creditCard;
    @Override
    public boolean pay(int amount) {
        if(cardIsPresent()) {
            System.out.println("Paying " + amount + " using credit card");
            creditCard.setAmount(creditCard.getAmount() - amount);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void collectPaymentDetails() {
        try{
            System.out.println("Enter the card details!!");
            String number = READER.readLine();
            System.out.println("Enter the card expiration date mm/yy");
            String date = READER.readLine();
            System.out.println("Enter the CVV code");
            String cvv = READER.readLine();

            creditCard = new CreditCard(number,date, cvv);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean cardIsPresent() {
        return creditCard != null;
    }
}
