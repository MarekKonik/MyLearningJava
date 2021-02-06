package dataClass.accountancy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountancyList {
    Scanner scanner = new Scanner(System.in);

    private List<Accountancy> accountancyList = new ArrayList<>();
    private String fileName = "accountancyList.dat";

    public void addAccountancyToList() {

        readObjectsFromListAccounting();


        String check;
        String shortName;
        String fullName;

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("                       Dodanie Ksiegowosci               ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("Podaj skrocona nazwe Ksiegowosci");
        shortName = scanner.next();
        System.out.println("Podaj pelna nazwe Biura Ksiegowego");
        fullName = scanner.next();

        accountancyList.add(new Accountancy(shortName, fullName));

        savingObjectsToListAccounting();


        System.out.println("Dodac osobe kontktowa y - tak n - nie");
        check = scanner.next();
        if (check.equals("y")) {

            System.out.println("Nowa osoba kontaktowa");

            for (int i = 0; i < accountancyList.size(); i++) {

                if (accountancyList.get(i).getShortName().equals(shortName)) {
                    accountancyList.get(i).addNewContactPerson();
                    savingObjectsToListAccounting();

                }
            }
        }

        System.out.println("Dodac adres do korenspondencji y - tak n - nie");
        check = scanner.nextLine();
        if (check.equals("y")) {
            for (int i = 0; i < accountancyList.size(); i++) {

                if (accountancyList.get(i).getShortName().equals(shortName)) {
                    accountancyList.get(i).addNewAddress();
                    savingObjectsToListAccounting();

                }

            }
        }

        savingObjectsToListAccounting();

    }


    private void savingObjectsToListAccounting() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(accountancyList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void readObjectsFromListAccounting() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            accountancyList = ((ArrayList<Accountancy>) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void removeObjectsFromListAccounting() {
        int check;
        readObjectsFromListAccounting();

        for (int i = 0; i < accountancyList.size(); i++) {
            System.out.println(i + " " + accountancyList.get(i).getFullName());
        }

        System.out.println("Podaj numer do usuniecia");
        check = scanner.nextInt();

        accountancyList.remove(accountancyList.get(check));


        savingObjectsToListAccounting();


    }


    public void showAllRecordsFromList() {
        readObjectsFromListAccounting();
        accountancyList.stream()
                .forEach(System.out::println);
    }

    public List<Accountancy> getAccountancyList() {
        return accountancyList;
    }

    public void setAccountancyList(List<Accountancy> accountancyList) {
        this.accountancyList = accountancyList;
    }

    @Override
    public String toString() {
        return "AccountancyList{" +
                "accountancyList=" + accountancyList +
                '}';
    }
}
