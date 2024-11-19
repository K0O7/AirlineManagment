package airline;

public interface ITransactionable {
    boolean authorizePayment(double amount);
    boolean refundPayment(double amount);
    String getTransactionDetails();
}
