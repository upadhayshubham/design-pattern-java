package BehavioralPatterns.strategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PayByPayPal implements PayStrategy {
    private static final Map<String, String> DATABASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));


    private String email;
    private String password;

    private boolean signedIn;

    static {
        //password --> email
        DATABASE.put("ShubhamUp", "shubhamu@gmail.com");
        DATABASE.put("Dhanuka390", "dhanuka@gmail.com");
    }

    @Override
    public boolean pay(int amount) {
        if(signedIn) {
            System.out.println("Paying " + amount + " using payPal");
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void collectPaymentDetails() {

        try {
            while (!signedIn) {
                System.out.println("Enter ur email");
                email = READER.readLine();
                System.out.println("Enter ur password");
                password = READER.readLine();
                if (verify()) {
                    System.out.println("Data Verfication has been successful");
                } else {
                    System.out.println("Wrong email or password");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean verify() {
        setSignedIn(email.equals(DATABASE.get(password)));
        return signedIn;
    }

    public void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}
