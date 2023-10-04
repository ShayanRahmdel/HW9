package service.impel;

import base.service.impel.BaseServiceImpl;
import entity.Order;
import repository.OrderRepository;
import service.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl extends BaseServiceImpl<Integer, Order, OrderRepository> implements OrderService {
    public OrderServiceImpl(OrderRepository repository) {
        super(repository);
    }


    @Override
    public void setNull(int productID) throws SQLException {

    }

    @Override
    public void deleteByProductID(int id) throws SQLException {
        repository.deleteByProductID(id);
    }

    @Override
    public boolean findProductId(int id) throws SQLException {
        return id == repository.findProductID(id);
    }

    @Override
    public void printCart(int id) throws SQLException {
        List<Order> cart = repository.printUserCart(id);
        System.out.println(cart);

    }

    @Override
    public void printTotalPrice(int id) throws SQLException {
        System.out.print("=========================Your total cart is ");
        System.out.println(repository.totalPrice(id));
    }
}
