import java.awt.*;
import java.awt.print.Book;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("test");

        String tilte = "poco";
        String author = "jak";
        int size = 34;


        Person kowalski = new Person("Kowalski", 24);
        Person krystian = new Person("Krystian", 48);


        Książka książka = new Książka("Janko Muzykant", "Henryk Sienkiewicz", 25);
        Książka książka1 = new Książka("Janko Muzykant", "Henryk Sienkiewicz", 25);
        Książka książka2 = new Książka("Naridziny","Jan Bochecki",456);


        kowalski.addKsiazka(książka);
        kowalski.addKsiazka(książka1);
        kowalski.addKsiazka(książka2);


        krystian.addKsiazka(new Książka("Sprawdzian","Marek",23));
        krystian.addKsiazka(new Książka(tilte,author,size));
        krystian.addKsiazka(książka2);







        System.out.println(kowalski);
        System.out.println(krystian);

        System.out.println("Ta osoba: "+ krystian.getName() + " posiada: "+ krystian.getKsiążkaList().size()+ " książek");
        System.out.println("Ta osoba: "+ kowalski.getName() + " posiada: "+ kowalski.getKsiążkaList().size()+ " książek");

        List<Książka> list = krystian.getKsiążkaList();


        //System.out.println(list);
    }

}
