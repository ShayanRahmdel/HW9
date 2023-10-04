package utility;

import repository.OrderRepository;
import repository.ProductRepository;
import repository.UserRepository;
import repository.impel.OrderRepositoryImpl;
import repository.impel.ProductRpositoryImpl;
import repository.impel.UserRepositoryImpl;
import service.OrderService;
import service.ProductService;
import service.UserService;
import service.impel.OrderServiceImpl;
import service.impel.ProductServiceImpl;
import service.impel.UserServiceImpl;

public class ApplicationContext {
    private static final ApplicationContext applicationContext = new ApplicationContext();
    private UserRepository userRepository;
    private UserService userService;

    private ProductRepository productRepository;

    private ProductService productService;


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

    public ProductRepository  getProductRepository() {
        if (productRepository == null) {
            productRepository = new ProductRpositoryImpl(
                    DataSource.getConnection()
            );
        }
        return productRepository;
    }

    public ProductService getProductService() {
        if (productService == null) {
            productService = new ProductServiceImpl(
                    getProductRepository()
            );
        }
        return productService;
    }


}
