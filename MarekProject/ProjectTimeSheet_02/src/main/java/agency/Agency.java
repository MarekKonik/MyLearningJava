package agency;

import extendingClasses.Address;
import extendingClasses.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agency {
    Scanner scanner = new Scanner(System.in);

    private String shortName;
    private String fullName;
    private List<Person> personContact = new ArrayList<>();
    private Address address;

    public Agency(String shortName, String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
    }


    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void addNewContactPerson() {
        String name;
        String phoneNumber;
        String mobileNumber;
        String email;

        System.out.println("Podaj imie ");
        name = scanner.nextLine();
        System.out.println("Podaj numer telefonu ");
        phoneNumber = scanner.nextLine();
        System.out.println("Podaj numer komórkowy");
        mobileNumber = scanner.nextLine();
        System.out.println("Podaj maila");
        email = scanner.nextLine();

        personContact.add(new Person(name, phoneNumber, mobileNumber, email));
    }

    public void addAdress() {
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

        this.address = new Address(houseNumber, streetName, cityName, postCode);
    }

    @Override
    public String toString() {
        return "Agency{" +
                "shortName='" + shortName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", personContact=" + personContact +
                ", address=" + address +
                '}';
    }
}
