package DTO;

public class PayloadClass {
    private int productId;
    private int cartId;
    private String pName;
    private String brand;
    private double price;
    private double discountedPrice;
    private int pQty;

    public PayloadClass() {
    }

    public int getProductId() {
        return this.productId;
    }

    public int getCartId() {
        return this.cartId;
    }

    public String getPName() {
        return this.pName;
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

    public int getPQty() {
        return this.pQty;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setPName(String pName) {
        this.pName = pName;
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

    public void setPQty(int pQty) {
        this.pQty = pQty;
    }
}
