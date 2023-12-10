package models;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> productList;


    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(String productId) {
        productList.removeIf(p -> p.getProductId().equalsIgnoreCase(productId.toLowerCase()));
    }

    private double getTotalCost() {
        double cost = 0;
        for (Product p : productList) {
            cost += p.getPrice();
        }
        return cost;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
}
