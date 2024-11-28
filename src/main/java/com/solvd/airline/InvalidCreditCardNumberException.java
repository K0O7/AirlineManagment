package main.java.com.solvd.airline;

public class InvalidCreditCardNumberException extends Exception {
    public InvalidCreditCardNumberException(String message) {
        super(message);
    }
}
