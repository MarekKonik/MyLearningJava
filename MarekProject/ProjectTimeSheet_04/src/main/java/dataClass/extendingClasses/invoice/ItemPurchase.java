package dataClass.extendingClasses.invoice;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

public class ItemPurchase implements Serializable {
    private String name;
    private int numberItems;
    private BigDecimal price;

    public ItemPurchase(String name, int numberItems, BigDecimal price) {
        this.name = name;
        this.numberItems = numberItems;
        this.price = price;
    }










    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberItems() {
        return numberItems;
    }

    public void setNumberItems(int numberItems) {
        this.numberItems = numberItems;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItemPurchase{" +
                "name='" + name + '\'' +
                ", numberItems=" + numberItems +
                ", price=" + price +
                '}';
    }
}
