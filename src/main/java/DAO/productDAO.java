package DAO;

import DTO.ProductDTO;

public interface ProductDAO extends Operation {
    int addProduct(ProductDTO var1);

    int updateProduct(ProductDTO var1);

    int deleteProduct(ProductDTO var1);
}
