package dataClass.accountancy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountancyList {

    Scanner scanner = new Scanner(System.in);
    private List<Accountancy> accountancyList = new ArrayList<>();
    private String fileName = "accountancyList";

    public void addAccountancyToList() {

        String shortName;
        String fullName;

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("                       Dodanie Ksiegowosci               ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("Podaj skrocona nazwe Ksiegowosci");
        shortName = scanner.nextLine();
        System.out.println("Podaj pelna nazwe Biura Ksiegowego");
        fullName = scanner.nextLine();

        accountancyList.add(new Accountancy(shortName, fullName));

        for (int i = 0; i < accountancyList.size(); i++) {

            System.out.println(accountancyList);

            accountancyList.get(i).getShortName().equals(shortName);//wyszukiwanie
            accountancyList.get(i).addAddressToAccountancy();//po znalezieniu uruchumienie funkcji
            accountancyList.get(i).addNewContactPerson();

        }



    }






    @Override
    public String toString() {
        return "AccountancyList{" +
                "accountancyList=" + accountancyList +
                '}';
    }
}
