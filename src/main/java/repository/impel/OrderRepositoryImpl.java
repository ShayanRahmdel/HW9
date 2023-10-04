package repository.impel;

import base.repository.impel.BaseRepositoryImpl;
import entity.Order;
import repository.OrderRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRepositoryImpl extends BaseRepositoryImpl<Integer, Order> implements OrderRepository {

    private Connection connection;

    public OrderRepositoryImpl(Connection connection){
        super(connection);
    }
    @Override
    public String getTableName() {
        return "orders";
    }

    @Override
    protected String getCountQuestionMarkForParams() {
        return "(?,?,?)";
    }

    @Override
    protected String getColumnName() {
        return "(user_id,elecproduct_id,shoesproduct_id)";
    }

    @Override
    protected void fillParamForStatement(PreparedStatement preparedStatement, Order entity, boolean b) throws SQLException {
        preparedStatement.setInt(1,entity.getUserID());
        preparedStatement.setInt(2,entity.getElecProduct_ID());
        preparedStatement.setInt(3,entity.getShoeProduct_ID());
    }

    @Override
    protected Order mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Order order = new Order(resultSet.getInt(1),
                resultSet.getInt(2),
                resultSet.getInt(3),
                resultSet.getInt(4));
        order.setId(resultSet.getInt(1));
        return order;
    }

    @Override
    protected String getUpdateQueryParams() {
        return "user_id=?,elecproduct_id=?,shoesproduct_id=?";
    }

    @Override
    public double sumPrize() {
        return 0;
    }
}
