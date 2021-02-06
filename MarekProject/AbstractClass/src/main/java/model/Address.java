package model;

public class Address {
    private String streetNumber;
    private String street;
    private String city;
    private String postCode;


    public Address(String streetNumber, String street, String city, String postCode) {
        this.streetNumber = streetNumber;
        this.street = street;
        this.city = city;
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetNumber='" + streetNumber + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
