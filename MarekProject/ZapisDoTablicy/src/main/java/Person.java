
import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private int age;
    private List<Książka>książkaList = new ArrayList<>();


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }



    public void addKsiazka(Książka książka){
        książkaList.add(książka);
    }


    public void setKsiążkaList(List<Książka> książkaList) {
        this.książkaList = książkaList;
    }

    public List<Książka>getKsiążkaList(){
        return książkaList;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", książkaList=" + książkaList +
                '}';
    }
}
