package dataClass;

import java.util.ArrayList;
import java.util.List;

public class ListAgency {

    private ArrayList<Agency>agencyArrayList = new ArrayList<>();

    public void addNewAgency(){
        agencyArrayList.add(new Agency("jan","janko"));
    }

}
