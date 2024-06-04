package MainApp;

import DAO.cartDAOImplementation;
import DAO.Operation;
import DTO.CartDTO;
import DTO.ProductDTO;
import DTO.cartDTO;
import jdk.dynalink.Operation;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserMainClass {
    private static final Scanner scanner;
    private static final Operation basicOperation;
    private static final cartDAOImplementation CART_DAO_IMPLEMENTATION;

    public UserMainClass() {
    }

    public static void main(String[] args) {
        operation();
    }

    private static void operation() {
        boolean status = true;

        while(status) {
            System.out.println("1. ADD PRODUCT TO THE CART");
            System.out.println("2. REMOVE PRODUCT FROM THE CART");
            System.out.println("3. DISPLAY ALL PRODUCT FROM THE CART");
            System.out.println("4. DISPLAY ALL PRODUCTS");
            System.out.println("5. EXIT");
            System.out.println("ENTER YOUR CHOICE");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addProductToTheCart();
                case 2:
                case 3:
                    break;
                case 4:
                    displayAllProducts();
                    break;
                case 5:
                    System.out.println("THANK U FOR VISITING");
                    System.exit(0);
                    break;
                default:
                    System.out.println("INVALID CHOICE");
            }
        }

    }

    private static void displayAllProducts() {
        List<ProductDTO> productDTOList = basicOperation.displayProduct();
        System.out.println("ID\tPRODUCT NAME\tBRAND\tPRICE\tDISCOUNTED PRICE\tQUANTITY");
        Iterator var1 = productDTOList.iterator();

        while(var1.hasNext()) {
            ProductDTO data = (ProductDTO)var1.next();
            PrintStream var10000 = System.out;
            int var10001 = data.getProductId();
            var10000.println("" + var10001 + "\t" + data.getProductName() + "\t" + data.getBrand() + "\t" + data.getPrice() + "\t" + data.getDiscountedPrice() + "\t" + data.getQuantity());
        }

    }

    private static void addProductToTheCart() {
        System.out.println("ENTER PRODUCT ID");
        int id = scanner.nextInt();
        System.out.println("ENTER PRODUCT QTY");
        int qty = scanner.nextInt();
        cartDTO c1 = new cartDTO();
        c1.setProductId(id);
        c1.setProductQty(qty);
        int count = CART_DAO_IMPLEMENTATION.addProductToTheCart(c1);
        if (count > 0) {
            System.out.println("PRODUCT ADDED TO THE CART");
        } else {
            System.out.println("SOMETHING WENT WRONG");
        }

    }

    static {
        scanner = new Scanner(System.in);
        basicOperation = (Operation) new cartDAOImplementation();
        CART_DAO_IMPLEMENTATION = (cartDAOImplementation)basicOperation;
    }

    private static class cartDAOImplementation {
        public int addProductToTheCart(cartDTO c1) {
        }
    }
}
