package agency;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgencyList {
    Scanner scanner = new Scanner(System.in);

    private List<Agency> agencyList = new ArrayList<>();

    public void addNewAgency() {
        String shortName;
        String fullName;

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Dodanie nowej Agencj!!!!");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("Podaj nazwe agancji:");
        shortName = scanner.nextLine();

        System.out.println("Podaj pełną nazwę agencji:");
        fullName = scanner.nextLine();

        agencyList.add(new Agency(shortName, fullName));
    }



    public void addPersonContactToAgency() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Dodanie nowej Osoby kontaktowej!!!!");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");

        String shortName;


        for (int i = 0; i < agencyList.size(); i++) {
            System.out.println("Indeks " + i + " - " + agencyList.get(i).getShortName());
        }
        System.out.println("=============================================================");

        System.out.println("Podaj nazwe agancji:");
        shortName = scanner.nextLine();

        for (Agency agency : agencyList) {
            if (agency.getShortName().equals(shortName)) {
                agency.addNewContactPerson();
            }else{

                System.out.println("Nie znaleziono takiej agencji: ");
            }
        }

    }




    public void addAddressToAgency(){

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Dodanie Adresu!!!!");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");


        for (int i = 0; i < agencyList.size(); i++) {
            System.out.println("Indeks "+ i+ " - "+ agencyList.get(i).getShortName());
        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        String shortName;

        System.out.println("Podaj nazwe agancji:");
        shortName = scanner.nextLine();

        for (Agency agency : agencyList) {
            if (agency.getShortName().equals(shortName)) {
                agency.addAdress();

            } else {
                System.out.println("Nie znaleziono takiej agencji: ");
            }
        }


    }


    public void printAllAgency() {

        agencyList.stream()
                .forEach(System.out::println);
    }

}
