package DAO;

import DTO.CartDTO;
import DTO.PayloadClass;

import java.util.List;

public interface CartDAO extends Operation{
    public int addProductToTheCart(cartDTO c);
    public int removeProductFromCart(cartDTO c);
    public List<PayloadClass> displayCartProducts();
}
