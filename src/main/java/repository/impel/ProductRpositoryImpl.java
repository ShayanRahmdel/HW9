package repository.impel;

import base.repository.impel.BaseRepositoryImpl;
import entity.Category;
import entity.Product;
import repository.ProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRpositoryImpl extends BaseRepositoryImpl<Integer, Product> implements ProductRepository {

    private Connection connection;
    public ProductRpositoryImpl(Connection connection) {
        super(connection);
        this.connection=connection;
    }

    @Override
    public String getTableName() {
        return "product";
    }

    @Override
    protected String getCountQuestionMarkForParams() {
        return "(?,?,?,?)";
    }

    @Override
    protected String getColumnName() {
        return "(name,price,stock,category)";
    }

    @Override
    protected void fillParamForStatement(PreparedStatement preparedStatement, Product entity, boolean b) throws SQLException {
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setDouble(2, entity.getPrice());
        preparedStatement.setInt(3, entity.getStock());
        preparedStatement.setString(4, entity.getCategory().toString());

    }

    @Override
    protected Product mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        String categoryStr = resultSet.getString("category");
        Category category = Category.valueOf(categoryStr);
        Product product = new Product(resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getDouble(3),
                resultSet.getInt(4),
                category);
        return product;

    }

    @Override
    protected String getUpdateQueryParams() {
        return " name=?,price=?,stock=?,category=? ";
    }


    @Override
    public int checkStock(int id) throws SQLException {
        String sql="SELECT stock FROM " + getTableName() + " where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int result = resultSet.getInt(1);
        return result;
    }

    @Override
    public void decrease(int id) throws SQLException {
        String sql="UPDATE "+ getTableName()+ " SET stock= stock-1 where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void increase(int id) throws SQLException {
        String sql="UPDATE "+ getTableName()+ " SET stock= stock+1 where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }
}
