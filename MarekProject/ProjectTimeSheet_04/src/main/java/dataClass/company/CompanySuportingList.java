package dataClass.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompanySuportingList {
    Scanner scanner = new Scanner(System.in);

    String fileName = "companySuportingList.dat";
    List<CompanySuporting> companySuportingList = new ArrayList<>();


    private void readingRecordsToList() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            companySuportingList = (ArrayList<CompanySuporting>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void savingRecordsToList() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(companySuportingList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public CompanySuporting returOneObject() {
        readingRecordsToList();

        int index;

        for (int i = 0; i < companySuportingList.size(); i++) {
            System.out.println(i + " " + companySuportingList.get(i).getFullName());
        }

        System.out.println("Podaj numer firmy");
        index = scanner.nextInt();

        return companySuportingList.get(index);
    }


    public void removeRecordsFromList() {
        readingRecordsToList();

        for (int i = 0; i < companySuportingList.size(); i++) {
            System.out.println(i + ". " + companySuportingList.get(i).getShortName());
        }

        System.out.println("Podaj rekord do usuniecia");
        int number = scanner.nextInt();

        companySuportingList.remove(number);

        savingRecordsToList();

    }


    public void addNewCompanySuportingToList() {

        readingRecordsToList();

        System.out.println("Podaj skrucona nazwe firmy");
        String shortName = scanner.nextLine();
        System.out.println("Podaj pelna nazwe firm");
        String fullName = scanner.nextLine();

        companySuportingList.add(new CompanySuporting(shortName, fullName));

        System.out.println("Czy chcesz dodac osobe kontaktowa y - tak, n - nie");
        String check = scanner.nextLine();

        if (check.equals("y")) {

            for (int i = 0; i < companySuportingList.size(); i++) {
                if (companySuportingList.get(i).getShortName().equals(shortName)) {
                    companySuportingList.get(i).addNewContactPerson();

                }
            }

        }

        System.out.println("Czy chcesz podac adres y - tak, n - nie");

        check = scanner.nextLine();
        if (check.equals("y")) {
            for (int i = 0; i < companySuportingList.size(); i++) {
                if (companySuportingList.get(i).getShortName().equals(shortName)) {
                    companySuportingList.get(i).addNewAddress();

                }


            }
        }
        savingRecordsToList();

    }

    @Override
    public String toString() {
        return "CompanySuportingList{" +
                "companySuportingList=" + companySuportingList +
                '}';
    }
}
