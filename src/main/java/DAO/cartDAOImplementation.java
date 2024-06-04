package DAO;

import ConnectionHelper.ConnectionHelper;
import DTO.CartDTO;
import DTO.PayloadClass;
import DTO.cartDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class cartDAOImplementation extends GeneralOperation implements cartDAO {
    private static final Connection connection = ConnectionHelper.getConnection();
    private static final String addProductToTheCart = "insert into cart values(?,?,?)";
    private static final String removeProductFromTheCart = "delete from cart where cart_id=?";
    private static final String displayAllCartProducts = "SELECT p.id,p.brand,p.name,p.price,p.discountedprice,\nc.product_qty\nFROM product p JOIN cart c ON c.product_ref=p.id;";

    public cartDAOImplementation() {
    }

    public int addProductToTheCart(cartDTO c) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into cart values(?,?,?)");
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, c.getProductId());
            preparedStatement.setInt(3, c.getProductQty());
            return preparedStatement.executeUpdate();
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }

    public int removeProductFromCart(cartDTO c) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from cart where cart_id=?");
            preparedStatement.setInt(1, c.getCartId());
            return preparedStatement.executeUpdate();
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }
    }

    @Override
    public int addProductToTheCart(cartDTO var1) {
        return 0;
    }

    public List<PayloadClass> displayCartProducts() {
        ArrayList<PayloadClass> payloadClassArrayList = new ArrayList();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT p.id,p.brand,p.name,p.price,p.discountedprice,\nc.product_qty\nFROM product p JOIN cart c ON c.product_ref=p.id;");
            PayloadClass payloadClass = null;

            while(rs.next()) {
                payloadClass = new PayloadClass();
                payloadClass.setProductId(rs.getInt(1));
                payloadClass.setBrand(rs.getString(2));
                payloadClass.setPName(rs.getString(3));
                payloadClass.setPrice(rs.getDouble(4));
                payloadClass.setDiscountedPrice(rs.getDouble(5));
                payloadClass.setPQty(rs.getInt(6));
                payloadClassArrayList.add(payloadClass);
            }

            return payloadClassArrayList;
        } catch (SQLException var5) {
            throw new RuntimeException(var5);
        }
    }
}
