package repository.impel;

import base.repository.impel.BaseRepositoryImpl;
import entity.User;
import repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UserRepositoryImpl extends BaseRepositoryImpl<Integer, User> implements UserRepository {

    private Connection connection;

    public UserRepositoryImpl(Connection connection){
        super(connection);
        this.connection=connection;
    }



    @Override
    public String getTableName() {
        return "users";
    }

    @Override
    protected String getCountQuestionMarkForParams() {
        return "(?,?,?,?,?)";
    }

    @Override
    protected String getColumnName() {
        return "(firstName,lastName,userName,password,postalcode)";
    }

    @Override
    protected void fillParamForStatement(PreparedStatement preparedStatement, User entity, boolean b) throws SQLException {
        preparedStatement.setString(1,entity.getFirstName());
        preparedStatement.setString(2,entity.getLastName());
        preparedStatement.setString(3,entity.getUserName());
        preparedStatement.setString(4,entity.getPassword());
        preparedStatement.setString(5,entity.getPostalCode());
    }


    @Override
    protected User mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        User user = new User(resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5),
                resultSet.getString(6));
        user.setId(resultSet.getInt(1));

        return user;
    }

    @Override
    protected String getUpdateQueryParams() {
        return "firstName=?,lastName=?,userName=?,password=?,postalcode=?";
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) throws SQLException {

        String sql = "SELECT * FROM " + getTableName() + " WHERE username = ? AND password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return mapResultSetToEntity(resultSet);
        }
        return null;
    }

    @Override
    public String findByUserName(String userName) throws SQLException {
        String sql = "SELECT userName FROM "+ getTableName()+ " WHERE username=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, userName);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("userName");
        } else {
            return null;
        }
    }

    @Override
    public String findByPassword(String password) throws SQLException {
            String sql = "SELECT password FROM "+ getTableName()+" WHERE password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("password");
            } else {
                return null;
            }
        }

    @Override
    public int findUserID(int id) throws SQLException {
            String sql = "SELECT id FROM users WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            } else {
                return 0;
            }
        }


}
