package TimeSheet;

import dataClass.agency.AgencyList;
import dataClass.company.CompanyList;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimeSheetList {
    Scanner scanner = new Scanner(System.in);

    private List<TimeWork> timeWorkList = new ArrayList<>();
    private String fileName = "timeSheetList.dat";


    public void removeObjectFomListTimeSheet() {
        try {
            readObjectsTimeSheet();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < timeWorkList.size(); i++) {
            System.out.println(i + " " + timeWorkList.get(i).getStartWork() + " Agencja pracy " + timeWorkList.get(i).getAgencyShortName() + " Firma " + timeWorkList.get(i).getCompanyShortName());
        }

        System.out.println("Podaj numer godzin pracy do usuniecia: ");
        int index = scanner.nextInt();
        timeWorkList.remove(timeWorkList.get(index));

        savingObjectTimeSheet();
    }


    private void savingObjectTimeSheet() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {

            oos.writeObject(timeWorkList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void readObjectsTimeSheet() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {

            timeWorkList = (ArrayList<TimeWork>) ois.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addNewTimeWork() {

        try {
            readObjectsTimeSheet();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        AgencyList agencyList = new AgencyList();
        CompanyList companyList = new CompanyList();

        String agency;
        String company;
        String startDate;
        String finishDate;
        String timeBreakString;
        BigDecimal rate;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        DateTimeFormatter localTime = DateTimeFormatter.ofPattern("H:mm");

        agency = agencyList.checkingListShortNameAgency();
        company = companyList.checkingListShortNameCompany();


        System.out.println("Podaj date i godzine rozpoczecia pracy:");
        startDate = scanner.nextLine();
        LocalDateTime startWork = LocalDateTime.parse(startDate, dateTimeFormatter);

        System.out.println("Podaj date i godzine zakonczenia pracy");
        finishDate = scanner.nextLine();
        LocalDateTime finishWork = LocalDateTime.parse(finishDate, dateTimeFormatter);

        System.out.println("Podaj dlugosc przerwy:");
        timeBreakString = scanner.nextLine();
        LocalTime timeBreak = LocalTime.parse(timeBreakString, localTime);

        System.out.print("Podaj Stawke:");
        rate = scanner.nextBigDecimal();

        timeWorkList.add(new TimeWork(agency, company, startWork, finishWork, timeBreak, rate));

        savingObjectTimeSheet();

    }


    public void showAllObjects(){
        try {
            readObjectsTimeSheet();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        timeWorkList.stream()
                .forEach(System.out::println);


    }

    @Override
    public String toString() {
        return "TimeSheetList{" +
                "timeWorkList=" + timeWorkList +
                '}';
    }
}
