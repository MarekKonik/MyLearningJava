package AbstarctClass;

import model.Address;
import model.Person;

import java.util.ArrayList;
import java.util.List;

public abstract class DataClass {

    String shortName;
    String fullName;
    List<Person> personContact = new ArrayList<>();
    Address address;

    public DataClass(String shortName, String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
    }

    public void addAddress(String streetNumber, String street, String city, String postCode){
        this.address = new Address(streetNumber,street,city,postCode);
    }

    public void addPersonContact(List<Person>list){
        personContact.addAll(list);

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
