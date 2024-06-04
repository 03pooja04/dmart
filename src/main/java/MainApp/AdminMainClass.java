package MainApp;

import DAO.Operation;
import DAO.ProductDAOImplementation;
import DTO.ProductDTO;
import jdk.dynalink.Operation;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdminMainClass {
    private static final Scanner scanner;
    private static final Operation productDao;
    private static final ProductDAOImplementation temp;

    public AdminMainClass() {
    }

    public static void main(String[] args) {
        productOperation();
    }

    public static void productOperation() {
        boolean status = true;

        while(status) {
            System.out.println("1. ADD PRODUCT");
            System.out.println("2. UPDATE PRODUCT");
            System.out.println("3. DELETE PRODUCT");
            System.out.println("4. DISPLAY PRODUCTS");
            System.out.println("5. EXIT");
            System.out.println("ENTER YOUR CHOICE");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                case 2:
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    displayProducts();
                    break;
                case 5:
                    System.out.println("THANK U FOR VISITING !");
                    status = false;
                    break;
                default:
                    System.out.println("INVALID CHOICE");
            }
        }

    }

    private static void deleteProduct() {
        System.out.println("ENTER PRODUCT ID");
        int id = scanner.nextInt();
        ProductDTO p = new ProductDTO();
        p.setProductId(id);
        int count = temp.deleteProduct(p);
        if (count > 0) {
            System.out.println("PRODUCT DELETED SUCCESSFULLY");
        } else {
            System.out.println("SOMETHING WENT WRONG !");
        }

    }

    private static void displayProducts() {
        List<ProductDTO> productList = productDao.displayProduct();
        System.out.println("ID\tPRODUCT NAME\tBRAND\tPRICE\tDISCOUNTED PRICE\tCATEGORY\tSUB-CATEGORY\tQUANTITY");
        Iterator var1 = productList.iterator();

        while(var1.hasNext()) {
            ProductDTO data = (ProductDTO)var1.next();
            PrintStream var10000 = System.out;
            int var10001 = data.getProductId();
            var10000.println("" + var10001 + "\t" + data.getProductName() + "\t" + data.getBrand() + "\t" + data.getPrice() + "\t" + data.getDiscountedPrice() + "\t" + data.getCategory() + "\t" + data.getSubCategory() + "\t" + data.getQuantity());
        }

    }

    static {
        scanner = new Scanner(System.in);
        productDao = new ProductDAOImplementation();
        temp = (ProductDAOImplementation)productDao;
    }

    private static class ProductDAOImplementation implements Operation {
        public int deleteProduct(ProductDTO p) {
            return 0;
        }
    }
}
