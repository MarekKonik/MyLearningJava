package model;

import AbstarctClass.DataClass;
import model.Address;
import model.Invoice;
import model.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Agency extends DataClass implements Serializable {

    List<Invoice>selerInvoice = new ArrayList<>();

    public Agency(String shortName, String fullName) {
        super(shortName, fullName);
    }

    @Override
    public void addPersonContact(List<Person> list) {
        super.addPersonContact(list);
    }

    @Override
    public void addAddress(String streetNumber, String street, String city, String postCode) {
        super.addAddress(streetNumber, street, city, postCode);
    }

    public void addSelerInvoice(List<Invoice>invoices){
        selerInvoice.addAll(invoices);
    }

    public Agency(String shortName, String fullName, List<Invoice> selerInvoice) {
        super(shortName, fullName);
        this.selerInvoice = selerInvoice;
    }

        public void printDataAgency(){

            System.out.println(toString());

            for (Invoice inv:selerInvoice) {
                System.out.println(inv);
            }

        }

}
