package model;

import java.io.Serializable;

public class Invoice implements Serializable {


    private TypeInvoice typeInvoice;
    private String numberInvoice;
    private double amountInvoice;

    public Invoice(TypeInvoice typeInvoice, String numberInvoice, double amountInvoice) {
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
