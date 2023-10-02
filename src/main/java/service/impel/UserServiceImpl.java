package service.impel;

import base.service.impel.BaseServiceImpl;
import entity.User;
import repository.UserRepository;
import service.UserService;

import java.sql.SQLException;

public class UserServiceImpl extends BaseServiceImpl<Integer, User, UserRepository>
        implements UserService {



  public UserServiceImpl(UserRepository userRepository){
      super(userRepository);
      this.userRepository=userRepository;
  }




    @Override
    public void findByUserNameAndPassword(String userName, String password) throws SQLException {
        User user = userRepository.findByUsernameAndPassword(userName, password);
        if (user != null && userName.equals(user.getUserName()) && password.equals(user.getPassword())) {
            System.out.println("Successful login");
        } else {
            System.out.println("Your username or password is incorrect");
        }
    }



}
