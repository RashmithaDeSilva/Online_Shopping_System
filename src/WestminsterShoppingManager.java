import models.Product;
import models.ShoppingManager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class WestminsterShoppingManager implements ShoppingManager {
    private static final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Product> productList;


    public WestminsterShoppingManager() {
        this.productList = new ArrayList<>();
    }


    @Override
    public void addItem(Product product) {
        productList.add(product);
    }

    @Override
    public void removeItem(String productId) {
        productList.removeIf(p -> p.getProductId().equalsIgnoreCase(productId.toLowerCase()));
    }

    @Override
    public ArrayList<Product> displayItems() {
        return productList;
    }

    @Override
    public void saveInFile() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("productListData.txt"))) {
            oos.writeObject(productList);
        }
    }


    private String getStrInput(String txt) {
        System.out.print(txt);
        return scanner.nextLine();
    }

    private int getIntInput(String txt) {
        boolean invalidInput = false;
        int input = -1;

        while (invalidInput) {
            try {
                String userInput = getStrInput(txt);
                input = Integer.parseInt(userInput);

            } catch (Exception e) {
                invalidInput = true;
            }
        }

        return input;
    }

    private double getDoubleInput(String txt) {
        boolean invalidInput = false;
        double input = -1;

        while (invalidInput) {
            try {
                String userInput = getStrInput(txt);
                input = Double.parseDouble(userInput);

            } catch (Exception e) {
                invalidInput = true;
            }
        }

        return input;
    }


    private int mainMenu() {
        System.out.println("\t\tOnline Shopping System\n");
        return getIntInput("Select > ");
    }
    public void startConsoleMenu() {
        mainMenu();
    }

    public static void main(String[] args) {
        WestminsterShoppingManager wsm = new WestminsterShoppingManager();

        wsm.startConsoleMenu();
    }
}
