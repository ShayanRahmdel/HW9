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


    public ElecRepositoryImpl(Connection connection){
        super(connection);
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
        preparedStatement.setString(1,entity.getElectronicProduct().getName());
        preparedStatement.setDouble(2,entity.getPrize());
        preparedStatement.setInt(3,entity.getStock());

    }

    @Override
    protected Electronic mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        ElectronicProduct electronicProduct = ElectronicProduct.valueOf(resultSet.getString("product"));
        double prize = resultSet.getDouble("prize");
        int stock = resultSet.getInt("stock");

        return new Electronic(id, electronicProduct, prize, stock);
    }

    @Override
    protected String getUpdateQueryParams() {
        return "(name=?,prize=?,stock=?)";
    }
}
