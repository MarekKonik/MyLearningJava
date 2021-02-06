import dataClass.Agency;
import dataClass.Comapany;
import dataClass.ListAgency;

import java.io.FileNotFoundException;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {



        //TimeWork timeWork = new TimeWork();
        ListTimeSheet listTimeSheet = new ListTimeSheet();

        listTimeSheet.addNewTimeWork();
        listTimeSheet.savingRecord();
        listTimeSheet.readRecord();

        listTimeSheet.addNewTimeWork();
        listTimeSheet.savingRecord();
        listTimeSheet.readRecord();


        listTimeSheet.showAllRecords();

    }
}
