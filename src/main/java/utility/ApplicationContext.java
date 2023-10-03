package utility;

import repository.ElecRepository;
import repository.UserRepository;
import repository.impel.ElecRepositoryImpl;
import repository.impel.UserRepositoryImpl;
import service.ElectronicService;
import service.UserService;
import service.impel.ElectronicServiceImpl;
import service.impel.UserServiceImpl;

public class ApplicationContext {
    private static final ApplicationContext applicationContext = new ApplicationContext();
    private UserRepository userRepository;
    private UserService userService;

    private ElecRepository elecRepository;

    private ElectronicService electronicService;


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

    public ElecRepository getElecRepository() {
        if (elecRepository == null) {
            elecRepository = new ElecRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return elecRepository;
    }


    public ElectronicService getElectronicService() {
        if (electronicService == null) {
            electronicService = new ElectronicServiceImpl(
                    getElecRepository()
            );
        }
        return electronicService;
    }

}
