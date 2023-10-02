package repository;

import base.repository.BaseRepository;
import entity.User;

import java.sql.SQLException;

public interface UserRepository extends BaseRepository<Integer, User> {
    User findByUsernameAndPassword(String username,String password) throws SQLException;
}
