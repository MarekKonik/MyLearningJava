package menu;

import dataClass.company.CompanyList;

import java.util.Scanner;

import static menu.MainMenu.myMainMenu;

public class CompanyMenu {

    public static void myCompanyMenu() {
        Scanner scanner = new Scanner(System.in);
        CompanyList companyList = new CompanyList();

        String menu[] = {"Dodanie nowej Firmy ", "Usuniecie usunieci Firmy ", "Przegladanie wszystkich Firm ", " ", "Exit"};

        int index;

        System.out.println("======================================================================");
        System.out.println("             Glowne Menue Ewidencji Firmy                           ");
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
                System.out.println("                  Dodanie Firmy                                  ");
                System.out.println("===================================================================");
                System.out.println();

                companyList.addNewComapany();
                myCompanyMenu();


                break;
            }
            case 1: {

                System.out.println("===================================================================");
                System.out.println("                  Usuniecie Firmy                                ");
                System.out.println("===================================================================");
                System.out.println();

                companyList.removeObjectFromCompanyList();
                myCompanyMenu();
                break;
            }

            case 2: {
                System.out.println("========================================================================");
                System.out.println("                   Przegladanie Firmy                                 ");
                System.out.println("========================================================================");
                System.out.println();

                companyList.showAllObjectsList();
                myCompanyMenu();
                break;
            }
            case 3: {
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
