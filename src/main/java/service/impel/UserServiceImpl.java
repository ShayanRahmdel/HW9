package service.impel;

import base.service.impel.BaseServiceImpl;
import entity.User;
import repository.UserRepository;
import service.UserService;

import java.sql.SQLException;

public class UserServiceImpl extends BaseServiceImpl<Integer, User, UserRepository>
        implements UserService {


    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.repository = userRepository;
    }


    @Override
    public void findByUserNameAndPassword(String userName, String password) throws SQLException {
        User user = repository.findByUsernameAndPassword(userName, password);
        if (user != null && userName.equals(user.getUserName()) && password.equals(user.getPassword())) {
            System.out.println("Successful login");
        } else {
            System.out.println("Your username or password is incorrect");
        }
    }

    @Override
    public boolean rightUserName(String userName) throws SQLException {
        repository.findByUserName(userName);
        return userName.equals(repository.findByUserName(userName));

    }

    @Override
    public boolean rightPassword(String password) throws SQLException {
        repository.findByPassword(password);
        return password.equals(repository.findByPassword(password));
    }

    @Override
    public boolean findUserId(int id) throws SQLException {
        return id == repository.findUserID(id);

    }

    @Override
    public int findIDByUserName(String userName) throws SQLException {
        return repository.findIDByUserName(userName);
    }


}
