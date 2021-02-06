package dataClass;

public class Person {
    private String name;
    private String phoneNumber;
    private String mobileNumber;
    private String email;


    public Person(){

    }

    public Person(String name, String phoneNumber, String mobileNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
