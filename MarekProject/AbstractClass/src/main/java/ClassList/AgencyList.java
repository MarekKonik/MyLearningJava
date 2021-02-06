package ClassList;

import model.Agency;
import model.Invoice;
import model.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AgencyList implements Serializable {

    private ArrayList<Agency> agencyArrayList = new ArrayList<>();
    private String fileName = "Agency.mks";


    public String getFileName() {
        return fileName;
    }

    public ArrayList<Agency> getAgencyArrayList() {
        return agencyArrayList;
    }

    public void setAgencyArrayList(ArrayList<Agency> agencyArrayList) {
        this.agencyArrayList = agencyArrayList;
    }

    public void addNewAgency(String shortName, String fullName){

        agencyArrayList.add(new Agency(shortName,fullName));
    }


    public void addElemenntClassAgency(String shortName, List<Invoice> invoiceList, List<Person>personList){

        for (Agency a : agencyArrayList){
           if(a.getShortName().equals(shortName)){
               a.addPersonContact(personList);
               a.addSelerInvoice(invoiceList);
               a.printDataAgency();

           }else {

           }
        }

    }



    @Override
    public String toString() {
        return "AgencyList{" +
                "agencyArrayList=" + agencyArrayList +
                '}';
    }
}
