package dataClass.company;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompanyList {
    Scanner scanner = new Scanner(System.in);

    List<Company> companyList = new ArrayList<>();
    String fileName = "companyList.dat";


    public void removeObjectFromCompanyList() {
        try {
            readObjectsCompany();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < companyList.size(); i++) {

            System.out.println(i + " " + companyList.get(i).getFullName());
        }

        System.out.println("Podaj numer firmy do usuniecia");
        int index = scanner.nextInt();

        companyList.remove(companyList.get(index));

        try {
            saveObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public int sizeListCompany() {
        return companyList.size();
    }


    public void showAllObjectsList() {

        try {
            readObjectsCompany();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Liczba zapisanych firm " + sizeListCompany());
        companyList.forEach(System.out::println);

    }


    private void saveObject() throws FileNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(companyList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void readObjectsCompany() throws IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        try {
            companyList = ((ArrayList<Company>) ois.readObject());


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public String checkingListShortNameCompany() {


        String name;
        int i = 0;

        try {
            readObjectsCompany();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (i = 0; i < companyList.size(); i++) {

            System.out.println(i + " " + companyList.get(i).getShortName() + " " + companyList.get(i).getFullName());

        }

        System.out.println("Podaj numer Firmy: ");
        i = scanner.nextInt();

        name = companyList.get(i).getShortName();

        return name;
    }


    public void addNewComapany() {

        try {
            readObjectsCompany();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DateTimeFormatter travelTimeFormater = DateTimeFormatter.ofPattern("H:mm");


        LocalTime travelTime;

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("                Dodanie nowej Firmy");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        String shortNameCompany;
        String fullNameCompany;
        int millageFromHomeToCompany;
        String travelTimeString;

        System.out.println("Podaj skróconą nazwe Firmy ");
        shortNameCompany = scanner.nextLine();
        System.out.println("Podaj pełną nazwe Firmy");
        fullNameCompany = scanner.nextLine();
        System.out.println("Podaj czas dojazdu do pracy");
        travelTimeString = scanner.nextLine();
        System.out.println("Podaj odległość");
        millageFromHomeToCompany = scanner.nextInt();
        System.out.println("Sprawdzenie poprawnosc !!");

        travelTime = LocalTime.parse(travelTimeString, travelTimeFormater);


        companyList.add(new Company(shortNameCompany, fullNameCompany, millageFromHomeToCompany, travelTime));

        try {
            saveObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "CompanyList{" +
                "companyList=" + companyList +
                '}';
    }
}
