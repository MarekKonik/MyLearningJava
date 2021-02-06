package dataClass.extendingClasses.invoice;

import dataClass.agency.Agency;
import dataClass.agency.AgencyList;
import dataClass.company.CompanySuporting;
import dataClass.extendingClasses.Address;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Invoice {
    Scanner scanner = new Scanner(System.in);

    private LocalDate dateInvoice; //Data wystawienia faktur
    private CompanySuporting sellersAddress; //ja lub CompanySuporting - invoicepurchase
    private Agency buyerAddress; //Agencja faktura inovoiceSales




    //Konstruktor do faktury zakupowej
    public Invoice(LocalDate dateInvoice, CompanySuporting sellersAddress) {
        this.dateInvoice = dateInvoice;
        this.sellersAddress = sellersAddress;
    }


    //Konstruktor do faktury sprzedazowej
    public Invoice(LocalDate dateInvoice, Agency buyerAddress) {
        this.dateInvoice = dateInvoice;
        this.buyerAddress = buyerAddress;
    }


    public LocalDate getDateInvoice() {
        return dateInvoice;
    }

    public void setDateInvoice(LocalDate dateInvoice) {
        this.dateInvoice = dateInvoice;
    }

    public CompanySuporting getSellersAddress() {
        return sellersAddress;
    }

    public void setSellersAddress(CompanySuporting sellersAddress) {
        this.sellersAddress = sellersAddress;
    }

    public Agency getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(Agency buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "dateInvoice=" + dateInvoice +
                ", sellersAddress=" + sellersAddress +
                ", buyerAddress=" + buyerAddress +
                '}';
    }
}
