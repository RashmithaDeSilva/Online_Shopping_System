package models;

public class Clothing extends Product {
    private double size;
    private String colour;


    public Clothing() {
    }

    public Clothing(String productId, String productName, int availableItems, double price, double size, String colour) {
        super(productId, productName, availableItems, price);
        this.size = size;
        this.colour = colour;
    }

    public Clothing(Product product, double size, String colour) {
        super.setProductId(product.getProductId());
        super.setProductName(product.getProductName());
        super.setAvailableItems(product.getAvailableItems());
        super.setPrice(product.getPrice());
        this.size = size;
        this.colour = colour;
    }


    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
