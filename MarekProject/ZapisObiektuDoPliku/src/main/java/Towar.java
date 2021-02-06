import java.io.Serializable;

/**
 *
 * @author Marek Konik
 * @date 2020-11-16
 * @version 1.00
 */
//   implements Serializable Trzeba dodać wszędzie, aby móc
//                           zapisywać obietky do pliku.


public class Towar implements Serializable {

    private String nazwa;
    private float cena;
    public Towar(String nazwa,float cena){
        this.nazwa=nazwa;
        this.cena=cena;
    }
    public Towar(){
        nazwa="brak";
        cena=0.0f;
    }
    public void zmiencene(float cena){
        this.cena=cena;
    }
    public float dajCene(){
        return cena;
    }

    public void zmiennazwe(String nazwa){
        this.nazwa=nazwa;
    }
    public String dajNazwe(){
        return nazwa;
    }
    public void odcz(){
        System.out.format("towar: %s, cena: %.2f \n", nazwa, cena);
    }

    @Override
    public String toString(){
        return String.format("towar:%s,cena: %.2f \n",nazwa,cena);
    }



}
