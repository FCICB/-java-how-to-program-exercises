import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class Invoice {


    private int partNumber;
    private String PartDescription;
    private int Quantity;
    private Double Price;
    public Invoice(int partNumber , String PartDescription , int Quantity, Double Price)
    {
        this.partNumber=partNumber;
        this.PartDescription=PartDescription;
        this.Price=Price;
        this.Quantity=Quantity;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getPartDescription() {
        return PartDescription;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public void setPartDescription(String partDescription) {
        PartDescription = partDescription;
    }
}
