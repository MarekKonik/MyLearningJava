package model;

public class Person {

    private String name;
    private String mobilephone;
    private String email;

    public Person(String name, String mobilephone, String email) {
        this.name = name;
        this.mobilephone = mobilephone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Preson{" +
                "name='" + name + '\'' +
                ", mobilephone='" + mobilephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
