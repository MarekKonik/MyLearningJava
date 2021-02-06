import java.io.*;

public class Main {

    public static void main(String[] args) {
        // Zapisuje dokładnie jeden obiekt do pliku
        public static void zapis(String nazwaPl, Zamowienie z)throws IOException{
            ObjectOutputStream pl=null;
            try{
                pl=new ObjectOutputStream(new FileOutputStream(nazwaPl));
                pl.writeObject(z);
                pl.flush();
            }
            finally{
                if(pl!=null)
                    pl.close();
            }
        }

        // Odczytuje dokładnie jeden obiekt z pliku i wyświetla o nim informację
        public static void odczyt(String nazwaPl)throws IOException,ClassNotFoundException{
            ObjectInputStream pl2=null;
            Zamowienie z = null;
            try{
                pl2=new ObjectInputStream(new FileInputStream(nazwaPl));
                z=(Zamowienie)pl2.readObject();

                z.odcz();

            } catch (EOFException ex) {
                System.out.println("Koniec pliku");
            }

            finally{
                if(pl2!=null)
                    pl2.close();
            }


        }

        // Odczytuje wiele obiektów z pliku (wszystkie) i wyświetla o nim informację
        public static void odczytCalego(String nazwaPl)throws IOException,ClassNotFoundException{
            ObjectInputStream pl2=null;
            Zamowienie z = null;
            try{
                pl2=new ObjectInputStream(new FileInputStream(nazwaPl));
                int l=1;
                while(true){
                    z=(Zamowienie)pl2.readObject();
                    System.out.println("\nZamówienie " + l++);
                    z.odcz();
                }

            } catch (EOFException ex) {
                System.out.println("Koniec pliku");
            }

            finally{
                if(pl2!=null)
                    pl2.close();
            }


        }

        // Dopisywanie do pliku
        public static void dopisanie(String nazwaPl, Zamowienie z)throws IOException, ClassNotFoundException{
            // Najwpierw odczytujemy z plkiu to, co było tam wcześniej
            Zamowienie[] tab = new Zamowienie[100]; // do tablicy
            ObjectInputStream pl2=null;
            try{
                pl2=new ObjectInputStream(new FileInputStream(nazwaPl));
                int l=0;
                while(true)
                    tab[l++]=(Zamowienie)pl2.readObject();

            } catch (EOFException ex) {
                // Program przeskakuje w to miejsce, kiedy dojdzie do końca pliku,
                // czyli kiedy wszystko już odczyta.
                // Teraz zamykamy plik, otwieramy w trybie zapisu i wpisujemy
                // do niego wszystko oraz dopisujemy to, co ma być dodane
                if(pl2!=null)
                    pl2.close();

                ObjectOutputStream pl=null;
                try{
                    pl=new ObjectOutputStream(new FileOutputStream(nazwaPl));
                    // Wpisujemy do pliku to, co w nim już było
                    for(int i=0; tab[i]!=null; i++)
                        pl.writeObject(tab[i]);

                    // i dopisujemy nowy obiekt
                    pl.writeObject(z);
                    pl.flush();
                }
                finally{
                    if(pl!=null)
                        pl.close();
                }
            }
        }

        public static void main(String[] args)throws IOException,ClassNotFoundException {
            Towar T=new Towar("mleko",2.29f);
            Towar T2=new Towar();
            Towar T3= new Towar("proszek do pieczenia",0.50f);
            Towar T4= new Towar("jajko", 0.20f);
            T.zmiencene(2.15f);
            T4.zmiencene(0.25f);
            T3.zmiencene(T3.dajCene()*1.1f); // podniesienie ceny o 10%
            T.zmiennazwe("kakao");
            T3.dajNazwe();
            T.odcz();
            T3.odcz();

            ElemZam el = new ElemZam(T, 10);
            ElemZam el2 = new ElemZam(T2);
            ElemZam el3= new ElemZam(T3,2);
            el.odcz();
            el2.odcz();
            el.kosztZamow();
            el3.kosztZamow();

            Zamowienie z = new Zamowienie();
            z.dodaj(el);
            z.dodaj(el2);
            z.dodaj(el3);

            System.out.println(z.kosztCalegoZamow());

            System.out.println("\n\n************ ZAPIS DO PLIKU");
            zapis("plik.dat", z);

            System.out.println("\n\n************ ODCZYT Z PLIKU");
            odczyt("plik.dat");

            System.out.println("\n\n************ DOPISYWANIE DO PLIKU");
            zapis("plik2.dat", z);

            Zamowienie z2 = new Zamowienie();
            z2.dodaj(el);
            z2.dodaj(el);
            z2.dodaj(el3);
            z2.dodaj(el3);

            dopisanie("plik2.dat", z2);

            Zamowienie z3 = new Zamowienie();
            z3.dodaj(el3);
            z3.dodaj(el3);
            z3.dodaj(el);
            z3.dodaj(el3);

            dopisanie("plik2.dat", z3);

            System.out.println("\n\n************ ODCZYT Z PLIKU KILKU OBIEKTÓW");
            odczytCalego("plik2.dat");
        }

    }

}
