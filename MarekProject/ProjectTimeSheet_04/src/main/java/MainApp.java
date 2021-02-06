import dataClass.accountancy.Accountancy;
import dataClass.accountancy.AccountancyList;
import dataClass.company.CompanySuportingList;

import java.io.IOException;

public class MainApp {
    public static void main(String[] args) throws IOException {


        //MainMenu.myMainMenu();
        CompanySuportingList companySuportingList = new CompanySuportingList();
        Accountancy accountancy = new Accountancy("Marek","Marek Konik");


        //companySuportingList.addNewCompanySuportingToList();
        //System.out.println(companySuportingList);


        accountancy.addNewPurchaseInvoiceToListInvoice();

        accountancy.showAllPurchase();

    }
}

