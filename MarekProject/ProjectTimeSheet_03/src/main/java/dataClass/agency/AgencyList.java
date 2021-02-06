package dataClass.agency;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgencyList {
    Scanner scanner = new Scanner(System.in);


    private List<Agency> agencyList = new ArrayList<>();
    private String fileName = "agencyList.dat";






    public void removeObjectFromAgencyList(){
        try {
            readObjectsAgency();
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < agencyList.size(); i++) {

            System.out.println(i+ " "+ agencyList.get(i).getFullName());
        }

        System.out.println("Podaj numer agencji ktora chcesz usunac: ");
        int index=scanner.nextInt();

        agencyList.remove(agencyList.get(index));

        savingObjectAgency();
    }








    private void savingObjectAgency() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(agencyList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObjectsAgency() throws IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        try {
            agencyList = ((ArrayList<Agency>) ois.readObject());


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public int sizeListAgency() {
        return agencyList.size();
    }


    public void showAllObjectsList() {
        try {
            readObjectsAgency();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Liczba zapisanych firm " + sizeListAgency());
        agencyList.forEach(System.out::println);

    }


    public void addNewAgencyToList() throws IOException {
        readObjectsAgency();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("                       Dodanie nowej Agencji               ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        String shortNameAgency;
        String fullNameAgency;


        System.out.println("Podaj skróconą nazwe Agencji ");
        shortNameAgency = scanner.nextLine();
        System.out.println("Podaj pełną nazwe Agencj");
        fullNameAgency = scanner.nextLine();


        agencyList.add(new Agency(shortNameAgency, fullNameAgency));

        savingObjectAgency();

        for (; ; ) {
            System.out.println("Chcesz dodac Osobe kontaktowa jezeli tak - y, jezeli nie - n  ");
            String check = scanner.nextLine();

            if (check.equals("y")) {
                System.out.println("Wprowadzamy nowa Osobe");

                for (int i = 0; i < agencyList.size(); i++) {
                    if (agencyList.get(i).getShortName().equals(shortNameAgency)) {

                        agencyList.get(i).addNewContactPerson();
                        savingObjectAgency();
                    }

                }

            } else {
                break;
            }

        }



            System.out.println("Chcesz dodac Adres kontaktowy jezeli tak - y, jezeli nie - n  ");
            String check = scanner.nextLine();

            if (check.equals("y")) {
                System.out.println("Wprowadzamy nowy Adres");

                for (int i = 0; i < agencyList.size(); i++) {
                    if (agencyList.get(i).getShortName().equals(shortNameAgency)) {
                        agencyList.get(i).addNewAddress();
                        savingObjectAgency();
                    }
                }

            }
            savingObjectAgency();


    }


    public String checkingListShortNameAgency() {

        try {
            readObjectsAgency();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String name;
        int i = 0;


        for (i = 0; i < agencyList.size(); i++) {

            System.out.println("Indeks " + i + " " + agencyList.get(i).getShortName());

        }

        System.out.println("Podaj numer Indeks Agencji: ");
        i = scanner.nextInt();

        name = agencyList.get(i).getShortName();

        return name;
    }


    public void addNewContactPersonToListAgency() {

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("         Dodanie nowej Osoby Kontaktowej do Agencji");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        try {
            readObjectsAgency();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < agencyList.size(); i++) {

            System.out.println("Indeks " + i + " " + agencyList.get(i).getShortName());

        }
        int i;
        System.out.println("Podaj numer indeksu: ");
        i = scanner.nextInt();
        agencyList.get(i).addNewContactPerson();

        savingObjectAgency();
    }

    public void addNewAddressToListAgency() {

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("            Dodanie nowego Adresu do Agencji               ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        try {
            readObjectsAgency();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < agencyList.size(); i++) {

            System.out.println("Indeks " + i + " " + agencyList.get(i).getShortName());

        }
        int i;
        System.out.println("Podaj numer indeksu: ");
        i = scanner.nextInt();
        agencyList.get(i).addNewAddress();

        savingObjectAgency();

    }


}
