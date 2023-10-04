package service.impel;

import base.service.impel.BaseServiceImpl;
import entity.Order;
import repository.OrderRepository;
import service.OrderService;

public class OrderServiceImpl extends BaseServiceImpl<Integer, Order, OrderRepository> implements OrderService {
    public OrderServiceImpl(OrderRepository repository) {
        super(repository);
    }
}
