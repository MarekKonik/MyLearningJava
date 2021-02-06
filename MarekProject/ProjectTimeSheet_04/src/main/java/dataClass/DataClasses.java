package dataClass;

import dataClass.extendingClasses.Address;
import dataClass.extendingClasses.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public abstract class DataClasses implements Serializable {

    private String shortName;
    private String fullName;
    private List<Person> personContact = new ArrayList<>();
    private Address address;



    public DataClasses(String shortName, String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
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

        address= new Address(houseNumber, streetName, cityName, postCode);
    }

    public void addNewContactPerson() {
        Scanner scanner = new Scanner(System.in);



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


        personContact.add(new Person(name,phoneNumber,mobileNumber,email));

    }


    public void test(){
        System.out.println("test");
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Person> getPersonContact() {
        return personContact;
    }

    public void setPersonContact(List<Person> personContact) {
        this.personContact = personContact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataClasses that = (DataClasses) o;
        return Objects.equals(shortName, that.shortName) && Objects.equals(fullName, that.fullName) && Objects.equals(personContact, that.personContact) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortName, fullName, personContact, address);
    }

    @Override
    public String toString() {
        return "DataClasses{" +
                "shortName='" + shortName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", personContact=" + personContact +
                ", address=" + address +
                '}';
    }
}
