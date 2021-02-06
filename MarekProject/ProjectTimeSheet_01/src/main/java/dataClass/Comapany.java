package dataClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Comapany extends DataClass{
    Scanner scanner = new Scanner(System.in);

    public int getMilageToHome() {
        return milageToHome;
    }

    public void setMilageToHome(int milageToHome) {
        this.milageToHome = milageToHome;
    }
    private List<Person> personList = new ArrayList<>();
    int milageToHome=0;


    public Comapany(String shortName, String fullName, int milageToHome) {
        super(shortName, fullName);
        this.milageToHome = milageToHome;
    }

    public void addNewContactPerson() {
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
        return super.getShortName()+getAddress()+getMilageToHome();
    }
}
