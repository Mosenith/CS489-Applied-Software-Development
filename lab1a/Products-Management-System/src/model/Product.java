package model;

import java.time.LocalDate;

public class Product {
    private long productId;
    private String Name;
    private LocalDate dateSupplied;
    private int quantityInStock;
    private double unitPrice;

    public Product(long productId, String name, LocalDate dateSupplied, int quantityInStock, double unitPrice) {
        this.productId = productId;
        Name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", Name='" + Name + '\'' +
                ", dateSupplied=" + dateSupplied +
                ", quantityInStock=" + quantityInStock +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public String toJSONString() {
        return String.format("\t{\"productId\":\"%d\", \"name\":\"%s\", \"dateSupplied\":\"%s\", " +
                "\"quantityInStock\":%d, \"unitPrice\":%.2f}", productId, Name, dateSupplied, quantityInStock, unitPrice);
    }

    public String toXMLString() {
        return String.format("\t<productId:\"%d\", name:\"%s\", dateSupplied:\"%s\" quantityInStock:\"%d\", unitPrice:\"%.2f\">",
                productId, Name, dateSupplied, quantityInStock, unitPrice);
    }

    public String toCSVString() {
        return String.format("%d, %s, %s, %d, %.2f", productId, Name, dateSupplied, quantityInStock, unitPrice);
    }
}
