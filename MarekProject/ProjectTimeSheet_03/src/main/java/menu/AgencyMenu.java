package menu;

import dataClass.agency.AgencyList;

import java.io.IOException;
import java.util.Scanner;

import static menu.MainMenu.myMainMenu;

public class AgencyMenu {
    public static void myAgencyMenu() {
        Scanner scanner = new Scanner(System.in);
        AgencyList agencyList = new AgencyList();


        String menu[] = {"Dodanie nowej Agencj ", "Usuniecie usunieci Agencji ", "Przegladanie Agencji ", "Dodanie nowej osoby Kontaktowej ", "Exit"};

        int index;

        System.out.println("======================================================================");
        System.out.println("             Glowne Menue Ewidencji Agencji                           ");
        System.out.println("======================================================================");
        System.out.println();


        for (
                int i = 0;
                i < menu.length; i++) {
            System.out.print(" " + i + " " + menu[i]);

        }

        System.out.println();
        System.out.println();
        System.out.println("Podaj numer");

        switch (index = scanner.nextInt()) {

            case 0: {
                System.out.println("===================================================================");
                System.out.println("                  Dodanie Agencji                                  ");
                System.out.println("===================================================================");
                System.out.println();

                try {
                    agencyList.addNewAgencyToList();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myAgencyMenu();


                break;
            }
            case 1: {

                System.out.println("===================================================================");
                System.out.println("                  Usuniecie Agencji                                ");
                System.out.println("===================================================================");
                System.out.println();

                agencyList.removeObjectFromAgencyList();
                myAgencyMenu();
                break;
            }

            case 2: {
                System.out.println("========================================================================");
                System.out.println("                   Przegladanie Agencji                                 ");
                System.out.println("========================================================================");
                System.out.println();

                agencyList.showAllObjectsList();
                myAgencyMenu();
                break;
            }
            case 3: {
                System.out.println("========================================================================");
                System.out.println("              Dodanie nowej osoby Kontaktowej                           ");
                System.out.println("========================================================================");
                System.out.println();

                agencyList.addNewContactPersonToListAgency();
                myAgencyMenu();
                break;
            }

            case 4: {
                System.out.println("EXIT");
                MainMenu.myMainMenu();
                break;
            }
            default: {
                System.out.println("Nieznany Indeks");
                myMainMenu();
            }
        }
    }
}
