package ClassList;

import model.Company;

import java.util.ArrayList;

public class CompanyList {

    ArrayList<Company>listCompany = new ArrayList<>();
    private String fileName = "Agency.mks";


    public void addNewCompany(String shortname, String fullnme, int milage){
        listCompany.add(new Company(shortname,fullnme,milage));
    }

}
