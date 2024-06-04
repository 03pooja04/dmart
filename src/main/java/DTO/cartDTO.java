package DTO;

public class cartDTO {
    private int cartId;
    private int productId;
    private int productQty;


    public int getCartId() {
        return this.cartId;
    }

    public int getProductId() {
        return this.productId;
    }

    public int getProductQty() {
        return this.productQty;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public cartDTO() {
        this.cartId = cartId;
        this.productId = productId;
        this.productQty = productQty;
    }

    public cartDTO() {
    }
}
