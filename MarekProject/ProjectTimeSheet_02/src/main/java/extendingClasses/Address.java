package extendingClasses;

public class Address {

    private String houseNumber;
    private String streetName;
    private String cityName;
    private String postCode;

    public Address() {
    }

    public Address(String houseNumber, String streetName, String cityName, String postCode) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.cityName = cityName;
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber='" + houseNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }

}
