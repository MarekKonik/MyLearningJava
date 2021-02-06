import java.math.BigDecimal;

public class Invoice {

    private String numberInvoice;
    private BigDecimal amount;

    public Invoice(String numberInvoice, BigDecimal amount) {
        this.numberInvoice = numberInvoice;
        this.amount = amount;
    }
}
