import java.io.Serializable;

public class ElemZam implements Serializable {

    private Towar towar;
    private int ile;

    public ElemZam(Towar towar,int ile){
        this.towar=towar;
        this.ile=ile;
    }

    public ElemZam(Towar towar){
        this.towar=towar;
        ile=1;
    }
    public float kosztZamow(){
        return ile * towar.dajCene();
    }
    public void odcz(){
        System.out.format("\tnazwa: %s, cena:%.2f, liczba sztuk:%d, koszt zamówienia:%.2f \n", towar.dajNazwe(),towar.dajCene(),ile,kosztZamow());
    }

    @Override
    public String toString(){
        return String.format("nazwa: %s, cena:%.2f, liczba sztuk:, koszt zamówienia:%.2f \n", towar.dajNazwe(),towar.dajCene(),ile,kosztZamow());
    }



}
