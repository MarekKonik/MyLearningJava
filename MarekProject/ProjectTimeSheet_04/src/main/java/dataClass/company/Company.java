package dataClass.company;

import dataClass.DataClasses;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

public class Company extends DataClasses implements Serializable {

    int millageFromHomeToCompany = 0;
    LocalTime travelTime;



    public Company(String shortName, String fullName, int millageFromHomeToCompany, LocalTime travelTime) {
        super(shortName, fullName);
        this.millageFromHomeToCompany = millageFromHomeToCompany;
        this.travelTime = travelTime;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Company company = (Company) o;
        return millageFromHomeToCompany == company.millageFromHomeToCompany && Objects.equals(travelTime, company.travelTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), millageFromHomeToCompany, travelTime);
    }

    @Override
    public String toString() {
        return super.getShortName()+" "+super.getFullName()+" Odleglosc do firmy "+ millageFromHomeToCompany +" mil. "+ " Czas dojazdu do pracy "+travelTime;
    }
}
