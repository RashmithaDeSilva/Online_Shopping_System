package models;

import java.util.Date;

public class Electronics extends Product {
    private String brand;
    private Date warranty;


    public Electronics() {
    }

    public Electronics(String productId, String productName, int availableItems, double price, String brand, Date warranty) {
        super(productId, productName, availableItems, price);
        this.brand = brand;
        this.warranty = warranty;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getWarranty() {
        return warranty;
    }

    public void setWarranty(Date warranty) {
        this.warranty = warranty;
    }
}
