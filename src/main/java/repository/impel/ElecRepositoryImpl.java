package repository.impel;

import base.repository.impel.BaseRepositoryImpl;
import entity.Electronic;
import entity.ElectronicProduct;
import repository.ElecRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ElecRepositoryImpl extends BaseRepositoryImpl<Integer, Electronic> implements ElecRepository {

    private Connection connection;

    public ElecRepositoryImpl(Connection connection) {
        super(connection);
        this.connection = connection;
    }


    @Override
    public String getTableName() {
        return "electronicproducts";
    }

    @Override
    protected String getCountQuestionMarkForParams() {
        return "(?,?,?)";
    }

    @Override
    protected String getColumnName() {
        return "(name,prize,stock)";
    }

    @Override
    protected void fillParamForStatement(PreparedStatement preparedStatement, Electronic entity, boolean b) throws SQLException {
        preparedStatement.setString(1, entity.getElectronicProduct().getName());
        preparedStatement.setDouble(2, entity.getPrize());
        preparedStatement.setInt(3, entity.getStock());

    }

    @Override
    protected Electronic mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        ElectronicProduct electronicProduct = ElectronicProduct.valueOf(resultSet.getString("name"));
        double prize = resultSet.getDouble("prize");
        int stock = resultSet.getInt("stock");

        return new Electronic(id, electronicProduct, prize, stock);
    }

    @Override
    protected String getUpdateQueryParams() {
        return "(name=?,prize=?,stock=?)";
    }

    @Override
    public int decreaseItem(int id) throws SQLException {
        String sql = "UPDATE " + getTableName() + " SET stock = stock-1 WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int result = preparedStatement.executeUpdate();
        return result;
    }

    @Override
    public int checkStock(int id) throws SQLException {
        String sql = "SELECT stock FROM " + getTableName() + " WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("stock");
        } else {
            return 0;
        }

    }

}
