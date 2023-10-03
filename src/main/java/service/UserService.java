package service;

import base.service.BaseService;
import entity.User;

import java.sql.SQLException;

public interface UserService extends BaseService<Integer, User> {


    void findByUserNameAndPassword(String userName,String password) throws SQLException;

     boolean rightUserName(String userName) throws SQLException;

     boolean rightPassword(String password) throws SQLException;
}
