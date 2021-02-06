package menu;

import TimeSheet.TimeSheetList;

import java.util.Scanner;

import static menu.MainMenu.myMainMenu;

public class TimeSheetMenu {

    public static void myTimeSheetMenu() {
        Scanner scanner = new Scanner(System.in);
        TimeSheetList timeSheetList = new TimeSheetList();




        String menu[] = {"Dodanie godzin pracy ", "Usuniecie godzin pracy ", "Przegladanie godzin pracy ", " ", "Exit"};

        int index;

        System.out.println("======================================================================");
        System.out.println("             Glowne Menue Ewidencji Czasu Pracy                       ");
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
                System.out.println("                  Dodanie godzin pracy"                             );
                System.out.println("===================================================================");
                System.out.println();
                timeSheetList.addNewTimeWork();

                myTimeSheetMenu();
                break;
            }
            case 1: {

                System.out.println("===================================================================");
                System.out.println("                  Usuniecie godzin pracy"                           );
                System.out.println("===================================================================");
                System.out.println();

                timeSheetList.removeObjectFomListTimeSheet();
                myTimeSheetMenu();
                break;
            }

            case 2: {System.out.println("===================================================================");
                System.out.println("                   Przegladanie godzin pracy                            ");
                System.out.println("========================================================================");
                System.out.println();

                timeSheetList.showAllObjects();
                myTimeSheetMenu();
                break;
            }
            case 3: {
                System.out.println("");
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