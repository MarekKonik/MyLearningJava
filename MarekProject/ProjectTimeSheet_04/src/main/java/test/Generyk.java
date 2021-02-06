package test;

public class Generyk {


    public static <T>void wypisz(T[] tablica, String znak){
        for(T element:tablica){
            System.out.println(element);
        }

        System.out.println(znak);
    }}
