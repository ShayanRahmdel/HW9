package utility;

import repository.UserRepository;
import repository.impel.UserRepositoryImpl;
import service.UserService;
import service.impel.UserServiceImpl;

public class ApplicationContext {
    private static final ApplicationContext applicationContext = new ApplicationContext();
    private UserRepository userRepository;
    private UserService userService;


    public ApplicationContext() {
    }


    public UserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return userRepository;
    }



    public UserService getUserService() {
        if (userService == null) {
            userService = new UserServiceImpl(
                    getUserRepository()
            );
        }
        return userService;
    }




}
