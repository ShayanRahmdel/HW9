package service;

import base.service.BaseService;
import entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderService extends BaseService<Integer, Order> {



    void setNull(int productID) throws SQLException;

    void deleteByProductID(int id) throws SQLException;

    boolean findProductId(int id) throws SQLException;

    void printCart(int id) throws SQLException;
}
