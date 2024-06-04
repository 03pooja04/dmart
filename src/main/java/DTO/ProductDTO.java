package DTO;

public class ProductDTO {
    private int productId;
    private String productName;
    private String brand;
    private double price;
    private double discountedPrice;
    private String category;
    private String subCategory;
    private String quantity;

    public int getProductId() {
        return this.productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getBrand() {
        return this.brand;
    }

    public double getPrice() {
        return this.price;
    }

    public double getDiscountedPrice() {
        return this.discountedPrice;
    }

    public String getCategory() {
        return this.category;
    }

    public String getSubCategory() {
        return this.subCategory;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public ProductDTO() {
    }

    public ProductDTO(int productId, String productName, String brand, double price, double discountedPrice, String category, String subCategory, String quantity) {
        this.productId = productId;
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.discountedPrice = discountedPrice;
        this.category = category;
        this.subCategory = subCategory;
        this.quantity = quantity;
    }
}
