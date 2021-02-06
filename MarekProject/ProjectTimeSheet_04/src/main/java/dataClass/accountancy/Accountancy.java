package dataClass.accountancy;

import dataClass.DataClasses;
import dataClass.company.CompanySuporting;
import dataClass.company.CompanySuportingList;
import dataClass.extendingClasses.invoice.InvoicePurchase;
import dataClass.extendingClasses.invoice.InvoiceSales;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Accountancy extends DataClasses implements Serializable {
    Scanner scanner = new Scanner(System.in);


    List<InvoiceSales> invoiceListSales = new ArrayList<>();
    List<InvoicePurchase> invoiceListPurchas = new ArrayList<>();

    public Accountancy(String shortName, String fullName) {
        super(shortName, fullName);
    }


    @Override
    public void addNewContactPerson() {
        super.addNewContactPerson();
    }

    @Override
    public void addNewAddress() {
        super.addNewAddress();
    }


    public void addNewPurchaseInvoiceToListInvoice() {
        DateTimeFormatter dataFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        CompanySuportingList companySuportingList = new CompanySuportingList();


        System.out.println("Podaj numer faktury: ");
        String invoiceNumber = scanner.next();

        System.out.println("Data zakupu:");
        String datePurchase = scanner.next();
        LocalDate dateInvoice =LocalDate.parse(datePurchase,dataFormater);


        CompanySuporting companySuporiting;
        companySuporiting = companySuportingList.returOneObject();

        invoiceListPurchas.add(new InvoicePurchase(dateInvoice, companySuporiting, invoiceNumber));

        for (int i = 0; i < invoiceListPurchas.size(); i++) {

            if(invoiceListPurchas.get(i).getInvoiceNumberPurchase().equals(invoiceNumber)){
                invoiceListPurchas.get(i).addItemPurchases();
            }
        }

    }


    public void showAllPurchase(){
        System.out.println(super.getFullName()+" "+invoiceListPurchas);
    }

    public List<InvoiceSales> getInvoiceListSales() {
        return invoiceListSales;
    }

    public void setInvoiceListSales(List<InvoiceSales> invoiceListSales) {
        this.invoiceListSales = invoiceListSales;
    }

    public List<InvoicePurchase> getInvoiceListPurchas() {
        return invoiceListPurchas;
    }

    public void setInvoiceListPurchas(List<InvoicePurchase> invoiceListPurchas) {
        this.invoiceListPurchas = invoiceListPurchas;
    }

    @Override
    public String toString() {
        return "Accountancy{" +
                "invoiceListSales=" + invoiceListSales +
                ", invoiceListPurchas=" + invoiceListPurchas +
                '}';
    }
}
