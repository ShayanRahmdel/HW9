package repository;

import base.repository.BaseRepository;
import entity.User;

import java.sql.SQLException;

public interface UserRepository extends BaseRepository<Integer, User> {
    User findByUsernameAndPassword(String username,String password) throws SQLException;

    String findByUserName(String userName) throws SQLException;

    String findByPassword(String password) throws SQLException;

    int findUserID(int id) throws SQLException;
}
