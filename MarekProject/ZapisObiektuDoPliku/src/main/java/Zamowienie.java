import java.io.Serializable;

public class Zamowienie implements Serializable {

    private int liczPozZ;
    private ElemZam[]tab = new ElemZam[100];

    public void Zamowienie(){
        liczPozZ=0;
    }
    public void dodaj(ElemZam el){
        tab[liczPozZ] = el;
        liczPozZ++;
    }

    public float kosztCalegoZamow(){
        float suma=0;
        for(int i=0; i<liczPozZ; i++){
            suma+=tab[i].kosztZamow();
        }


        return suma;
    }

    public void odcz(){
        System.out.format("Koszt całego zamówienia wynosi %.2f zł, a na jego poszególne części składa się:\n", kosztCalegoZamow());
        for(int i=0; i<liczPozZ; i++){
            tab[i].odcz();
        }
    }



}
