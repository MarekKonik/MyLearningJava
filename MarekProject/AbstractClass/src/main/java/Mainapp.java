import ClassList.AgencyList;
import ClassList.CompanyList;
import ClassList.WriteReadClass;
import model.*;

import java.util.Arrays;
import java.util.List;

public class Mainapp {

    public static void main(String[] args) {
        System.out.println("Test");


        List<Person> personContact = Arrays.asList(new Person("Monika", "0773321234", "monika@tag.com"),
                new Person("Marek", "07754559315", "mkonik@vp.pl"));
        List<Person> personContact1 = Arrays.asList(new Person("Wojtek", "1235646548", "Wojtek@tag.com"),
                new Person("Kamil", "fs15", "wojtekkonik@vp.pl"));


        List<Invoice> invoiceList = Arrays.asList(new Invoice(TypeInvoice.SALES, "123/20202", 1234.00),
                new Invoice(TypeInvoice.SALES, "124/20202", 1587.48));
        List<Invoice> invoiceList1 = Arrays.asList(new Invoice(TypeInvoice.SALES, "125/20202", 34.00),
                new Invoice(TypeInvoice.SALES, "126/20202", 15.48));


        String shortName = "Tag";
        String fullName = "Tag Requitment";
        int milage = 14;


        WriteReadClass writeReadClass = new WriteReadClass();
        AgencyList agencyList = new AgencyList();
        CompanyList companyList = new CompanyList();



        companyList.addNewCompany("KJ","KJ Company Limited", 16);
        

        agencyList.addNewAgency("Tag", "Tag Requitmant");
        agencyList.addNewAgency("Accept", "Accept LTD");
        agencyList.addNewAgency("Irish", "Irish Full Company");


        agencyList.addElemenntClassAgency("Tag", invoiceList, personContact);
        agencyList.addElemenntClassAgency("Accept", invoiceList1, personContact1);


        writeReadClass.writeObject(agencyList.getFileName(), agencyList.getAgencyArrayList());


        System.out.println("===============================================================================");
        System.out.println("===============================================================================");
        System.out.println("===============================================================================");

        System.out.println(agencyList);

    }
}
