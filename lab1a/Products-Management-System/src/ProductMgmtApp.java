import model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ProductMgmtApp {
    public static void main(String[] args) {
        Product[] products = {
                new Product(3128874119L, "Banana",
                        LocalDate.of(2023,1,24), 124, 0.55),
                new Product(2927458265L, "Apple",
                        LocalDate.of(2023,1,24), 18, 1.09),
                new Product(9189927460L, "Carrot",
                        LocalDate.of(2023,1,24), 89, 2.99)
        };

        printProducts(products);

    }

    public static void printProducts(Product[] products) {
        Arrays.sort(products, Comparator.comparing(Product::getName));

        // For JSON format
        System.out.println("Printed in JSON format\n[");
        for(int i=0; i<products.length; i++) {
            if(i != products.length - 1) {
                System.out.println(products[i].toJSONString() + ",");
            } else {
                System.out.println(products[i].toJSONString());
            }
        }
        System.out.println("]");

        System.out.println("------------------------------");

        // For XML Format
        System.out.println("Printed in XML format");
        System.out.println("<?xml version=\"1.0\"?>");
        System.out.println("<products>");
        for(int i=0; i<products.length; i++) {
            if(i != products.length - 1) {
                System.out.println(products[i].toXMLString() + ",");
            } else {
                System.out.println(products[i].toXMLString());
            }
        }
        System.out.println("</products>");

        System.out.println("------------------------------");

        System.out.println("Printed in Coma-Separated Value (CSV) format");
        for(Product p : products) {
            System.out.println(p.toCSVString());
        }
    }
}