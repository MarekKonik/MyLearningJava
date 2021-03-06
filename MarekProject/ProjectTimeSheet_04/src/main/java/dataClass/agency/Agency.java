package dataClass.agency;

import dataClass.DataClasses;

import java.io.Serializable;

public class Agency extends DataClasses implements Serializable {


    public Agency(String shortName, String fullName) {
        super(shortName, fullName);
    }

    @Override
    public void addNewContactPerson() {
        super.addNewContactPerson();
    }

    @Override
    public void addNewAddress() {
        super.addNewAddress();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
