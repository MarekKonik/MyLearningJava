package dataClass.extendingClasses.invoice;

import TimeSheet.TimeWork;
import dataClass.agency.Agency;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InvoiceSales extends Invoice {

    private int invoiceID;
    private static final int invoiceNumber = 0;
    private List<TimeWork> positionListInvoice = new ArrayList<>();

    public InvoiceSales(LocalDate dateInvoice, Agency buyerAddress) {
        super(dateInvoice, buyerAddress);
    }


    public List<TimeWork> getPositionListInvoice() {
        return positionListInvoice;
    }

    public void setPositionListInvoice(List<TimeWork> positionListInvoice) {
        this.positionListInvoice = positionListInvoice;
    }


//W konstruktorze nadeajem wartosc faktury
    //this.invoiceID = invoiceNumber++;


}
