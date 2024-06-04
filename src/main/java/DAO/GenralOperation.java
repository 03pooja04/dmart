package DAO;

import ConnectionHelper.ConnectionHelper;
import DTO.ProductDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class GeneralOperation implements Operation {
    private static final Connection connection = ConnectionHelper.getConnection();
    private static final String displayProduct = "select * from product";

    public GeneralOperation() {
    }

    public List<ProductDTO> displayProduct() {
        List<ProductDTO> productDTOArrayList = new ArrayList();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from dmart");
            ProductDTO p = null;

            while(rs.next()) {
                p = new ProductDTO();
                p.setProductId(rs.getInt(8));
                p.setProductName(rs.getString(1));
                p.setBrand(rs.getString(2));
                p.setPrice(rs.getDouble(3));
                p.setDiscountedPrice(rs.getDouble(4));
                p.setCategory(rs.getString(5));
                p.setSubCategory(rs.getString(6));
                p.setQuantity(rs.getString(7));
                productDTOArrayList.add(p);
            }

            return productDTOArrayList;
        } catch (SQLException var5) {
            throw new RuntimeException(var5);
        }
    }
}
