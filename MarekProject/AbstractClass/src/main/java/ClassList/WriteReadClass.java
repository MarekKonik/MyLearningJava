package ClassList;

import AbstarctClass.DataClass;
import model.Agency;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WriteReadClass<T extends DataClass> {



    public void writeObject(String fileName, ArrayList<Agency> agency){

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(agency);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
