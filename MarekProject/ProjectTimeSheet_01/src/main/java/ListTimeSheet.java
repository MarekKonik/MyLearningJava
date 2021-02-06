import dataClass.Agency;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ListTimeSheet {
    Scanner scanner = new Scanner(System.in);


    private ArrayList<TimeWork> timeWorkList = new ArrayList<>();
    private String fileName="Agency.dat";



    public void addNewTimeWork() throws FileNotFoundException {

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
            LocalTime timeBreak = LocalTime.parse(timeBreakString, localTime);
            //long timeOver = timeBreak.getMinute();


            System.out.print("Podaj Stawke:");
            rate = scanner.nextBigDecimal();

            timeWorkList.add(new TimeWork(agency, company, startWork, finishWork, timeBreak, rate));



    }

    public void remowRecord(){


        for (int i =0; i<timeWorkList.size();i++){
            System.out.println("Indeks "+ i+" "+timeWorkList.get(i).getCompanyShortName()+ " "+ timeWorkList.get(i).getStartWork());
        }

        System.out.println("Podaj numer indeksu:");
        int indeks = scanner.nextInt();
        timeWorkList.remove(indeks);



    }


    public int sizeList(){
        return timeWorkList.size();
    }


    public void savingRecord() throws FileNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {

            oos.writeObject(timeWorkList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void readRecord() throws FileNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {

            timeWorkList = (ArrayList<TimeWork>) ois.readObject();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void showAllRecords() throws FileNotFoundException {
        readRecord();
        System.out.println("Ilość zapisanych rekordów "+ sizeList());
        timeWorkList.stream()
                .forEach(System.out::println);
    }
}
