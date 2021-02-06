package dataClass;

import java.math.BigDecimal;

public class Invoice {


    private TypeInvoice typeInvoice;
    private String numberInvoice;
    private BigDecimal amountInvoice;

    public Invoice(){}

    public Invoice(TypeInvoice typeInvoice, String numberInvoice, BigDecimal amountInvoice) {
        this.typeInvoice = typeInvoice;
        this.numberInvoice = numberInvoice;
        this.amountInvoice = amountInvoice;
    }


    @Override
    public String toString() {
        return "Invoice{" +
                "typeInvoice=" + typeInvoice +
                ", numberInvoice='" + numberInvoice + '\'' +
                ", amountInvoice=" + amountInvoice +
                '}';
    }
}
