package dataClass.extendingClasses.invoice;

import dataClass.company.CompanySuporting;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvoicePurchase extends Invoice implements Serializable {
    Scanner scanner = new Scanner(System.in);

    private String invoiceNumberPurchase;


    List<ItemPurchase> itemPurchaseList = new ArrayList<>();

    public InvoicePurchase(LocalDate dateInvoice, CompanySuporting sellersAddress, String invoiceNumberPurchase) {
        super(dateInvoice, sellersAddress);
        this.invoiceNumberPurchase = invoiceNumberPurchase;

    }


    public void addItemPurchases() {
        String check;


        addPurchase();
        for (; ; ) {
            System.out.println("Dodac kolejna pozycje na fakturze y - tak n - nie");
            check = scanner.next();
            if (check.equals("n")) {
                break;
            } else {
                addPurchase();
            }
        }
        sumaAndVatPurchases();
    }


    private void sumaAndVatPurchases() {
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal vAT;
        for (int i = 0; i < itemPurchaseList.size(); i++) {


            sum = sum.add(itemPurchaseList.get(i).getPrice().multiply(BigDecimal.valueOf(itemPurchaseList.get(i).getNumberItems())));
        }

        vAT = sum.multiply(BigDecimal.valueOf(0.20));
        BigDecimal sumVAT = sum.add(vAT);

        System.out.println("Suma wynosi " + sum + " suma VAT " + vAT + " razem: " + (sumVAT));
    }


    private void addPurchase() {


        System.out.println("Podaj nazwe produktu");
        String name = scanner.next();
        System.out.println("Podaj ilosc sztuk");
        int numberItems = scanner.nextInt();
        System.out.println("Podaj cene:");
        BigDecimal price = scanner.nextBigDecimal();

        itemPurchaseList.add(new ItemPurchase(name, numberItems, price));

    }


    public String getInvoiceNumberPurchase() {
        return invoiceNumberPurchase;
    }

    public void setInvoiceNumberPurchase(String invoiceNumberPurchase) {
        this.invoiceNumberPurchase = invoiceNumberPurchase;
    }

    public List<ItemPurchase> getItemPurchaseList() {
        return itemPurchaseList;
    }

    public void setItemPurchaseList(List<ItemPurchase> itemPurchaseList) {
        this.itemPurchaseList = itemPurchaseList;
    }

    @Override
    public String toString() {
        return "InvoicePurchase{" +
                "invoiceNumberPurchase='" + invoiceNumberPurchase + '\'' +
                ", itemPurchaseList=" + itemPurchaseList+
                '}';
    }
}
