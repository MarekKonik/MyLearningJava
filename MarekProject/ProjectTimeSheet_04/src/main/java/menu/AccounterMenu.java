package menu;

import dataClass.company.CompanyList;

import java.util.Scanner;

import static menu.MainMenu.myMainMenu;

public class AccounterMenu {


    public static void myAccounterMenu() {
        Scanner scanner = new Scanner(System.in);
        CompanyList companyList = new CompanyList();


        String menu[] = {"Dodanie nowej Faktury ", " Aktualizacja Faktur ", "Przegladanie Faktur ", "Dane Teleadresowe ksiegowosci ", "Exit"};

        int index;

        System.out.println("======================================================================");
        System.out.println("             Glowne Menue Ksiegowsci                           ");
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
                System.out.println("                  Dodanie Faktury                                  ");
                System.out.println("===================================================================");
                System.out.println();

                myAccounterMenu();


                break;
            }
            case 1: {

                System.out.println("===================================================================");
                System.out.println("                  Aktualizacja Faktur                                ");
                System.out.println("===================================================================");
                System.out.println();
                viwingInvoiceTypeMenu();
                myAccounterMenu();
                break;
            }

            case 2: {
                System.out.println("========================================================================");
                System.out.println("                   Przegladanie Faktur                                 ");
                System.out.println("========================================================================");
                System.out.println();
                viwingInvoiceTypeMenu();
                myAccounterMenu();
                break;

            }
            case 3: {
                System.out.println("========================================================================");
                System.out.println("                   Dane Teleadresowe ksiegowosc                         ");
                System.out.println("========================================================================");
                System.out.println();

                myAccounterMenu();
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

    public static void viwingInvoiceTypeMenu() {
        String typeInvoice[] = {"Purchase", "Seling"};
        for (int i = 0; i < typeInvoice.length; i++) {


            System.out.println(i + " " + typeInvoice[i]);


        }
    }


}
