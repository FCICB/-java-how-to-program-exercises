import java.util.Arrays;
import java.util.Comparator;
public class InvoiceIMP {
    public static void main(String[] args) {
        Invoice[] invoices= {
                new Invoice(20, "smart", 4, 55.55),
                new Invoice(10,"power",5,77.22),
                new Invoice(4,"Hammer",7,777.9)
        };
        System.out.println("Sorted By PartDiscription");
        Arrays.stream(invoices)
                .sorted(Comparator.comparing(Invoice::getPartDescription))
                .forEach(System.out::println);
        System.out.println("Sorted By PartNumber");
        Arrays.stream(invoices)
                .sorted(Comparator.comparing(Invoice::getPartNumber))
                .forEach(System.out::println);

        System.out.println("Sorted By Quantity");
        Arrays.stream(invoices)
                .sorted(Comparator.comparing(Invoice::getQuantity))
                .forEach(System.out::println);

        System.out.println("Sorted By Price");
        Arrays.stream(invoices)
                .sorted(Comparator.comparing(Invoice::getPrice))
                .forEach(System.out::println);


    }
}
