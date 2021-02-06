package menu;

import java.util.Scanner;

public class MainMenu {


    public static void myMainMenu() {

        Scanner scanner = new Scanner(System.in);
        String menu[] = {"Godziny Pracy", "Agencja pracy", "Firma", "Ksiegowosc", "Exit"};

        int index;

        System.out.println("======================================================================");
        System.out.println("                         Glowne Menue                                 ");
        System.out.println("======================================================================");
        System.out.println();


        for (int i = 0; i < menu.length; i++) {
            System.out.print(" " + i + " " + menu[i]);

        }

        System.out.println();
        System.out.println();
        System.out.println("Podaj numer");

        switch (index = scanner.nextInt()) {

            case 0: {
                System.out.println("Godziny Pracy");
                TimeSheetMenu.myTimeSheetMenu();
                break;
            }
            case 1: {
                System.out.println("Agencje Pracy");
                AgencyMenu.myAgencyMenu();
                break;
            }

            case 2: {
                System.out.println("Firma");
                CompanyMenu.myCompanyMenu();
                break;
            }
            case 3: {
                System.out.println("Ksiegowosc");
                AccounterMenu.myAccounterMenu();
                break;
            }

            case 4: {
                System.out.println("EXIT");
                break;
            }
            default: {
                System.out.println("Nieznany Indeks");
                myMainMenu();
            }

        }

    }


}
