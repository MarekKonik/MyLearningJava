import java.util.ArrayList;
import java.util.List;

public class DataClass {

    private String nameShort;
    private String nameFull;
    private List<Person> contactPerson = new ArrayList<>();
    private Adreess adreess;

    public DataClass(String nameShort, String nameFull) {
        this.nameShort = nameShort;
        this.nameFull = nameFull;
    }

    public void addContactPerson(String name,String phoneNumber,String email){
        contactPerson.add(new Person(name,phoneNumber,email));
    }

    public void addAdreess(String streetNumber,String streetName,String city,String postCode){

        this.adreess = new Adreess(streetNumber,streetName,city,postCode);

    }
}
