public class Książka {

    private String tytul;
    private String author;
    private int iloscStorn;


    public Książka(String tytul, String author, int iloscStorn) {
        this.tytul = tytul;
        this.author = author;
        this.iloscStorn = iloscStorn;
    }


    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getIloscStorn() {
        return iloscStorn;
    }

    public void setIloscStorn(int iloscStorn) {
        this.iloscStorn = iloscStorn;
    }


    @Override
    public String toString() {
        return "Książka{" +
                "tytul='" + tytul + '\'' +
                ", author='" + author + '\'' +
                ", iloscStorn=" + iloscStorn +
                '}';
    }
}
