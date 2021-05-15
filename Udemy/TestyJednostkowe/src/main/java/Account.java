/*
* 1 Tworzymy konto urzytkownika które domyslnie nie jest aktywne
* dopiero po kliknieciu w podane miejsce konto zostanie aktywowanie
* */



public class Account {
    private boolean active;


    //konstruktor
    public Account(){
        this.active = false;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    //metoda która aktywuje konto
    public void activate(){
        this.active = true;
    }

}
