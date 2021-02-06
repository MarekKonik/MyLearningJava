package dataClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class DataClass {


    private String shortName;
    private String fullName;
    private List<Person> personContact = new ArrayList<>();
    private Address address;

    public DataClass(){}

    public DataClass(String shortName, String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
    }

    protected abstract void addNewAddress();


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

    @Override
    public String toString() {
        return "DataClass{" +
                "shortName='" + shortName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", personContact=" + personContact +
                ", address=" + address +
                '}';
    }
}
