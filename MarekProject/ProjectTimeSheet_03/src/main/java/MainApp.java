import dataClass.accountancy.AccountancyList;
import dataClass.agency.AgencyList;
import menu.MainMenu;

import java.io.IOException;

public class MainApp {
    public static void main(String[] args) throws IOException {


        //MainMenu.myMainMenu();
        AccountancyList accountancyList = new AccountancyList();

        accountancyList.addAccountancyToList();

        System.out.println(accountancyList);

    }
}

