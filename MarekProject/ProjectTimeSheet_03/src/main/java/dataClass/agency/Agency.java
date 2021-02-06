package dataClass.agency;

import dataClass.DataClasses;
import dataClass.extendingClasses.Address;
import dataClass.extendingClasses.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agency extends DataClasses implements Serializable{


    public Agency(String shortName, String fullName) {
        super(shortName, fullName);
    }

    public void addNewContactPerson() {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();


        String name;
        String phoneNumber;
        String mobileNumber;
        String email;

        System.out.println("Podaj imie ");
        name = scanner.nextLine();
        System.out.println("Podaj telefon");
        phoneNumber = scanner.nextLine();
        System.out.println("Podaj numer komurkowy");
        mobileNumber = scanner.nextLine();
        System.out.println("Podaj maila");
        email = scanner.nextLine();


        personList.add(new Person(name,phoneNumber,mobileNumber,email));

        super.setPersonContact(personList);
    }

    public void addNewAddress() {
        Scanner scanner = new Scanner(System.in);
        String houseNumber;
        String streetName;
        String cityName;
        String postCode;

        System.out.println("Numer domu");
        houseNumber = scanner.nextLine();
        System.out.println("Ulica");
        streetName = scanner.nextLine();
        System.out.println("Miasto");
        cityName = scanner.nextLine();
        System.out.println("Kod Pocztowy");
        postCode = scanner.nextLine();

        super.setAddress(new Address(houseNumber, streetName, cityName, postCode));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
