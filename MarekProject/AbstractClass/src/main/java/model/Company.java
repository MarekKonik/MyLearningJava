package model;

import AbstarctClass.DataClass;

public class Company extends DataClass {

    int milageFromHome = 0;


    public Company(String shortName, String fullName,int milageFromHome) {
        super(shortName, fullName);
        this.milageFromHome = milageFromHome;
    }
}
