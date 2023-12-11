import models.Electronics;
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
        boolean validInput = true;
        int input = -1;

        while (validInput) {
            try {
                String userInput = getStrInput(txt);
                input = Integer.parseInt(userInput);
                validInput = false;

            } catch (Exception e) {
                System.out.println("invade input data type, try again with integer !");
            }
        }

        return input;
    }

    private double getDoubleInput(String txt) {
        boolean validInput = true;
        double input = -1;

        while (validInput) {
            try {
                String userInput = getStrInput(txt);
                input = Double.parseDouble(userInput);
                validInput = false;

            } catch (Exception e) {
                System.out.println("invade input data type, try again with float !");
                validInput = true;
            }
        }

        return input;
    }

    private Product getProductDetails() {
        int loopbreak = -1;
        String id = null;
        String name = null;
        int itemCount = 0;
        double price = 0;

        while (loopbreak != 0) {
            id = getStrInput("Product ID > ");

            if(!productList.isEmpty()) {
                for (Product p : productList) {
                    if(id.equalsIgnoreCase(p.getProductId().toLowerCase())) {
                        System.out.println("This ID is already use enter another ne ID !\n");
                        loopbreak = 1;
                        break;

                    } else {
                        loopbreak = 0;
                    }
                }

            } else {
                loopbreak = 0;
            }


        }

        loopbreak = -1;
        while (loopbreak != 0) {
            name = getStrInput("Product name > ");
            
            if (!name.isEmpty()) {
                loopbreak = 0;
                
            } else {
                System.out.println("This Name is invade, try again !\n");
            }
        }

        loopbreak = -1;
        while (loopbreak != 0) {
            itemCount = getIntInput("Available item count > ");

            if (itemCount > 0) {
                loopbreak = 0;

            } else {
                System.out.println("Invade item count, try again !\n");
            }
        }

        loopbreak = -1;
        while (loopbreak != 0) {
            price = getDoubleInput("Price (per item) > ");

            if (price > 0) {
                loopbreak = 0;

            } else {
                System.out.println("Invade price, try again !\n");
            }
        }
        
        return new Product(id, name, itemCount, price);
    }

    private void addNewProduct() {
        Product product;
        boolean loopbreak = true;

        while (loopbreak) {
            System.out.println("********************************************************");
            System.out.println("\t\tAdd a new product\n");
            System.out.println("\t1. Electronics");
            System.out.println("\t2. Clothing");
            System.out.println("\t3. Back to main menu");

            switch (getIntInput("\nSelect > ")) {
                case 1:
                    product = new Electronics(getProductDetails() ,null, null);

                    break;

                case 2:
                    break;

                case 3:
                    loopbreak = false;
                    break;

                default:
                    System.out.println("Invalid input try again !");
                    break;
            }

            System.out.println("\n");
        }
    }

    private int mainMenu() {
        System.out.println("********************************************************");
        System.out.println("\t\tOnline Shopping System\n");
        System.out.println("\t1. Add a new product");
        System.out.println("\t2. Delete a product");
        System.out.println("\t3. Print the list of the products");
        System.out.println("\t4. Save in a file");
        System.out.println("\t0. Exit");
        return getIntInput("\nSelect > ");
    }
    public void startConsoleMenu() {
        boolean loopbreak = true;
        while (loopbreak) {
           switch (mainMenu()) {
               case 0:
                   loopbreak = false;
                   break;

               case 1:
                   addNewProduct();
                   break;

               case 2:
                   break;

               case 3:
                   break;

               case 4:
                   break;

               default:
                   System.out.println("Invalid input try again !");
                   break;
           }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        WestminsterShoppingManager wsm = new WestminsterShoppingManager();

        wsm.startConsoleMenu();
    }
}
