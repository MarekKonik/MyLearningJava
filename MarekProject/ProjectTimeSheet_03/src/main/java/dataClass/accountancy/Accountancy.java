package dataClass.accountancy;

import dataClass.DataClasses;
import dataClass.extendingClasses.Address;
import dataClass.extendingClasses.invoice.Invoice;
import dataClass.extendingClasses.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Accountancy extends DataClasses implements Serializable {
    Scanner scanner = new Scanner(System.in);


    List<Invoice> invoiceList = new ArrayList<>();

    public Accountancy(String shortName, String fullName) {
        super(shortName, fullName);
    }


    public void addAddressToAccountancy() {
        String houseNumber;
        String streetName;
        String cityName;
        String postCode;

        System.out.println("Podaj numer domu");
        houseNumber = scanner.nextLine();
        System.out.println("Nazwa ulicy ");
        streetName = scanner.nextLine();
        System.out.println("Miasto");
        cityName = scanner.nextLine();
        System.out.println("Kod pocztowy");
        postCode = scanner.nextLine();

        super.setAddress(new Address(houseNumber, streetName, cityName, postCode));

    }


    public void addNewContactPerson() {
        List<Person> personContact = new ArrayList<>();
        String name;
        String phoneNumber;
        String mobileNumber;
        String email;

        System.out.println("Podaj imie");
        name = scanner.nextLine();
        System.out.println("Podaj numer telefonu");
        phoneNumber = scanner.nextLine();
        System.out.println("Podaj numer telefonu komurkowego");
        mobileNumber = scanner.nextLine();
        System.out.println("Podaj email ");
        email = scanner.nextLine();

        personContact.add(new Person(name, phoneNumber, mobileNumber, email));

        super.setPersonContact(personContact);

        super.test();
    }

    @Override
    public void test() {
        super.test();
    }

    @Override
    public String toString() {
        return super.getShortName() + " " + super.getFullName() + " "+getPersonContact()+" "+super.getAddress();
    }
}
