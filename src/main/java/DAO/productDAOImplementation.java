package DAO;

import ConnectionHelper.ConnectionHelper;
import DTO.ProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDAOImplementation extends GeneralOperation implements ProductDAO {
    private static final Connection connection = ConnectionHelper.getConnection();
    private static final String insertData = "insert into product values(?,?,?,?,?,?,?,?)";
    private static final String updateProduct = "update product set discountedPrice=? where id=?";
    private static final String deleteProduct = "delete from product where id=?";

    public ProductDAOImplementation() {
    }

    public int addProduct(ProductDTO p) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("insert into product values(?,?,?,?,?,?,?,?)");
            pstmt.setString(1, p.getProductName());
            pstmt.setString(2, p.getBrand());
            pstmt.setDouble(3, p.getPrice());
            pstmt.setDouble(4, p.getDiscountedPrice());
            pstmt.setString(5, p.getCategory());
            pstmt.setString(6, p.getSubCategory());
            pstmt.setString(7, p.getQuantity());
            pstmt.setInt(8, 0);
            return pstmt.executeUpdate();
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }

    public int updateProduct(ProductDTO p) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("update dmart set discountedPrice=? where id=?");
            pstmt.setDouble(1, p.getDiscountedPrice());
            pstmt.setInt(2, p.getProductId());
            return pstmt.executeUpdate();
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }

    public int deleteProduct(ProductDTO p) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("delete from dmart where id=?");
            pstmt.setInt(1, p.getProductId());
            return pstmt.executeUpdate();
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }
}
