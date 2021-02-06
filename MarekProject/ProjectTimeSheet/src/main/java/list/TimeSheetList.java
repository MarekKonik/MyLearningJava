package list;

import model.DayWorking;

import java.io.*;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimeSheetList {

    Scanner scanner = new Scanner(System.in);


    private List<DayWorking> workingList = new ArrayList<>();
    private String fileName = "TimeSheet.bin";

    public void addNewWorkingDay() {

        String agency;
        String company;
        String startDate;
        String finishDate;
        String timeBreakString;
        BigDecimal rate;

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        DateTimeFormatter localTime = DateTimeFormatter.ofPattern("H:mm");

        System.out.println("Podaj nazwe agencji");
        agency = scanner.nextLine();
        System.out.println("Podaj nazwe firmy");
        company = scanner.nextLine();
        System.out.println("Podaj Date i godzine rozpoczęcia pracy");
        startDate = scanner.nextLine();
        LocalDateTime startWork = LocalDateTime.parse(startDate, dateTimeFormatter);
        System.out.println("Podaj Date i godzine zakończnia pracy");
        finishDate = scanner.nextLine();
        LocalDateTime finishWork = LocalDateTime.parse(finishDate, dateTimeFormatter);
        System.out.println("Długość przerwy");
        timeBreakString = scanner.nextLine();
        LocalTime timeBreak = LocalTime.parse(timeBreakString,localTime);
        long timeOver = timeBreak.getMinute();



        System.out.println("Podaj Stawke:");
        rate = scanner.nextBigDecimal();




        double timeWork = (Duration.between(startWork, finishWork).minusMinutes(timeOver).toMinutes()/60.00);

        System.out.println("Czas pracy: " + timeWork + " Przerwa " +timeOver+ " minut." +" Zarobiono " + rate.multiply(BigDecimal.valueOf(timeWork)));

       workingList.add(new DayWorking(agency,company,startWork,finishWork,timeBreak,rate));


       writeTimeSheetToFile();
        System.out.println("-------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("odczyt z pliku");
        readTimeSheetToFile();



        MenuApi.timesheetMenu();

    }


    public void printList() {

        for (DayWorking d : workingList) {

            System.out.println(d);
        }

    }


    public void writeTimeSheetToFile(){

        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream(fileName));
            os.writeObject(workingList);
            System.out.println("Zapisano do pliku");
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readTimeSheetToFile(){

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));

            workingList = (List<DayWorking>) ois.readObject();

            for (DayWorking timeSheet: workingList){
                System.out.println(timeSheet);
            }


            printList();

            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
