package base.repository.impel;

import base.entity.BaseEntity;
import base.repository.BaseRepository;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class  BaseRepositoryImpl<ID extends Serializable,TYPE extends BaseEntity<ID>>implements BaseRepository<ID,TYPE> {

    private final Connection connection;

    public BaseRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void save(TYPE entity) throws SQLException {
        String sql =  "INSERT INTO " + getTableName() + " " + getColumnName() + " VALUES " + getCountQuestionMarkForParams(); ;
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        fillParamForStatement(preparedStatement, entity, false);
        preparedStatement.executeUpdate();
    }




    @Override
    public List findAll() throws SQLException {
        String sql = " SELECT * FROM " + getTableName();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<TYPE> entities = new ArrayList<>();
            while (resultSet.next()) {
                entities.add(mapResultSetToEntity(resultSet));
            }
            return entities;
        }
    }



    @Override
    public TYPE findById(ID id) throws SQLException {
        String sql = "SELECT * FROM " + getTableName() + " WHERE id = ? ;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, (Integer) id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                return mapResultSetToEntity(resultSet);
        }
        return null;
    }

    @Override
    public void update(TYPE entity) throws SQLException {
        String sql = "UPDATE " + getTableName() + " SET " + getUpdateQueryParams() + " WHERE id = " + entity.getId();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            fillParamForStatement(preparedStatement, entity, true);
            preparedStatement.executeUpdate();
        }

    }



    @Override
    public void delete(ID id) throws SQLException { String sql = "DELETE FROM " + getTableName() + " WHERE id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, (int) id);
            preparedStatement.executeUpdate();
        }



    }

    public abstract String getTableName();

    protected abstract String getCountQuestionMarkForParams();

    protected abstract String getColumnName();

    protected abstract void fillParamForStatement(PreparedStatement preparedStatement, TYPE entity, boolean b);

    protected abstract TYPE mapResultSetToEntity(ResultSet resultSet);

    protected abstract String getUpdateQueryParams();
}
