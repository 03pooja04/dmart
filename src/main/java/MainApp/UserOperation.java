package MainApp;

import DAO.Operation;
import DAO.productDAOImplementation;
import DTO.ProductDTO;
import jdk.dynalink.Operation;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserOperation {
    private static final Scanner scanner;
    private static final Operation operation;

    public UserOperation() {
    }

    public void operation() {
        boolean status = true;

        while(status) {
            System.out.println("1. DISPLAY PRODUCTS");
            System.out.println("2. ADD PRODUCT TO THE CART");
            System.out.println("3. VIEW CART PRODUCTS");
            System.out.println("4 EXIT");
            System.out.println("ENTER YOUR CHOICE");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayProducts();
                case 2:
                case 3:
                    break;
                case 4:
                    System.out.println("THANK U FOR VISITING !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("INVALID CHOICE");
            }
        }

    }

    private static void displayProducts() {
        List<ProductDTO> productList = operation.displayProduct();
        System.out.println("ID\tPRODUCT NAME\tBRAND\tPRICE\tDISCOUNTED PRICE\tQUANTITY");
        Iterator var1 = productList.iterator();

        while(var1.hasNext()) {
            ProductDTO data = (ProductDTO)var1.next();
            PrintStream var10000 = System.out;
            int var10001 = data.getProductId();
            var10000.println("" + var10001 + "\t" + data.getProductName() + "\t" + data.getBrand() + "\t" + data.getPrice() + "\t" + data.getDiscountedPrice() + "\t" + data.getQuantity());
        }

    }

    private static void addProductToTheCart() {
    }

    static {
        scanner = new Scanner(System.in);
        operation = new ProductDAOImplementation();
    }

    private static class ProductDAOImplementation implements Operation {
    }
}
