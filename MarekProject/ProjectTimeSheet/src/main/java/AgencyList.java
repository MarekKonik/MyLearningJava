import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AgencyList extends DataClass {

    private List<Invoice>invoiceList = new ArrayList<>();


    public AgencyList(String nameShort, String nameFull) {
        super(nameShort, nameFull);
    }

    public void addNewInvoiceToList(String numberInvoice, BigDecimal amount){
        invoiceList.add(new Invoice(numberInvoice, amount));
    }


}
