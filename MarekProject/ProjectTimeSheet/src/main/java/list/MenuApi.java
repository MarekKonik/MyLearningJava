package list;

import java.util.Scanner;

public class MenuApi {


    public static void myMainMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("M E N U ");
        System.out.println("==================================================================================================================================");
        System.out.print("1. Timesheet  ");
        System.out.print("2. method in bulding  ");
        System.out.print("3. method in bulding  ");
        System.out.print("4. method in bulding  ");
        System.out.print("5. method in bulding  ");
        System.out.println("6. Exit");
        System.out.println("===================================================================================================================================");
        System.out.println("Enter choice:");

       int choice = sc.nextInt();

        switch (choice){
            case 1:
                System.out.println("TimeSheet");
                MenuApi.timesheetMenu();
                break;
            case 2:
                System.out.println("In bulding");
                break;
            case 3:
                System.out.println("In bulding");
                break;
            case 4:
                System.out.println("In bulding");
                break;
            case 5:
                System.out.println("In bulding");
                break;
            case 6:
                System.out.println("EXIT");
                break;

        }
        sc.close();
    }

    public static void timesheetMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("M E N U ");
        System.out.println("============================================================================================");
        System.out.print("1. Add new Timesheet  ");
        System.out.print("2. Delete Timesheet  ");
        System.out.print("3. Update Timesheet  ");
        System.out.print("4. Find Timesheet  ");
        System.out.print("5. All Timesheet  ");
        System.out.println("6. Exit");
        System.out.println("============================================================================================");
        System.out.println("Enter choice:");

        int choice = sc.nextInt();

        switch (choice){
            case 1:
                System.out.println("TimeSheet");
                TimeSheetList timeSheetList = new TimeSheetList();
                timeSheetList.addNewWorkingDay();
                break;
            case 2:
                System.out.println("In bulding");
                break;
            case 3:
                System.out.println("In bulding");
                break;
            case 4:
                System.out.println("In bulding");
                break;
            case 5:
                System.out.println("In bulding");
                break;
            case 6:
                System.out.println("EXIT");
                MenuApi.myMainMenu();
                break;

        }
        sc.close();
    }

}
