package repository.impel;

import base.repository.impel.BaseRepositoryImpl;
import entity.Order;
import repository.OrderRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl extends BaseRepositoryImpl<Integer, Order> implements OrderRepository {

    private Connection connection;

    public OrderRepositoryImpl(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    @Override
    public String getTableName() {
        return "orders";
    }

    @Override
    protected String getCountQuestionMarkForParams() {
        return "(?,?)";
    }

    @Override
    protected String getColumnName() {
        return "(user_id,product_id)";
    }

    @Override
    protected void fillParamForStatement(PreparedStatement preparedStatement, Order entity, boolean b) throws SQLException {
        preparedStatement.setInt(1, entity.getUserID());
        preparedStatement.setInt(2, entity.getProductID());


    }

    @Override
    protected Order mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Order order = new Order(resultSet.getInt(1),
                resultSet.getInt(2),
                resultSet.getInt(3));
        order.setId(resultSet.getInt(1));
        return order;
    }

    @Override
    protected String getUpdateQueryParams() {
        return "( user_id=?,product_id=? )";
    }

    @Override
    public double sumPrize() {
        return 0;
    }


    @Override
    public void deleteByProductID(int id) throws SQLException {
        String sql = "DELETE FROM " + getTableName() + " WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public int findProductID(int id) throws SQLException {
        String sql = "SELECT product_id FROM orders WHERE user_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("id");
        } else {
            return 0;
        }
    }

    @Override
    public List<Order> printUserCart(int id) throws SQLException {
        List<Order> cart = new ArrayList<>();
        String sql = "SELECT o.id, p.name AS product_name, COUNT(*) AS product_count, SUM(p.price) AS total_price\n" +
                "FROM orders o\n" +
                "         INNER JOIN product p ON o.product_id = p.id\n" +
                "where user_id=?\n" +
                "GROUP BY p.name,o.id;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Order order = new Order(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4));
            cart.add(order);

        }
        return cart;
    }


}
