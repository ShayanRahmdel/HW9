package utility;

import repository.ElecRepository;
import repository.OrderRepository;
import repository.ShoeRepository;
import repository.UserRepository;
import repository.impel.ElecRepositoryImpl;
import repository.impel.OrderRepositoryImpl;
import repository.impel.ShoeRepositoryImpl;
import repository.impel.UserRepositoryImpl;
import service.ElectronicService;
import service.OrderService;
import service.ShoeService;
import service.UserService;
import service.impel.ElectronicServiceImpl;
import service.impel.OrderServiceImpl;
import service.impel.ShoeServiceImpl;
import service.impel.UserServiceImpl;

public class ApplicationContext {
    private static final ApplicationContext applicationContext = new ApplicationContext();
    private UserRepository userRepository;
    private UserService userService;

    private ElecRepository elecRepository;

    private ElectronicService electronicService;

    private ShoeRepository shoeRepository;

    private ShoeService shoeService;

    private OrderRepository orderRepository;

    private OrderService orderService;


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

    public ShoeRepository getShoeRepository() {
        if (shoeRepository == null) {
            shoeRepository = new ShoeRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return shoeRepository;
    }

    public ShoeService getShoeService() {
        if (shoeService == null) {
            shoeService = new ShoeServiceImpl(
                    getShoeRepository()
            );
        }
        return shoeService;
    }


    public OrderRepository  getOrderRepository() {
        if (orderRepository == null) {
            orderRepository = new OrderRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return orderRepository;
    }

    public OrderService getOrderService() {
        if (orderService == null) {
            orderService = new OrderServiceImpl(
                    getOrderRepository()
            );
        }
        return orderService;
    }
}
