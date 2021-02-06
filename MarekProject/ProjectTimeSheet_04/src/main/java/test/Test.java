package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import static test.Generyk.wypisz;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*String  cyfra ="Napis.fhs";
        String []imiona = {"jan","wojtek", "janek"};
        Integer[] liczba = {1,2,3,5,6,1};


        wypisz(imiona,cyfra);
        wypisz(liczba,cyfra);*/


        BigDecimal[] tab = new BigDecimal[5];
        BigDecimal smuma = BigDecimal.ZERO;

        for (int i = 0; i < tab.length; i++) {
            System.out.println("Podaj liczbe: ");
            BigDecimal l = scanner.nextBigDecimal();

            tab[i] = l;

        }

        for (int i = 0; i < tab.length; i++) {

            System.out.println(tab[i]);
            smuma = smuma.add(tab[i]);

        }

        System.out.println("Wynik "+smuma);
    }


}
