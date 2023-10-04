package repository;

import base.repository.BaseRepository;
import entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderRepository extends BaseRepository<Integer, Order> {

    double sumPrize();



    void deleteByProductID(int id) throws SQLException;
    int findProductID(int id) throws SQLException;

    List<Order> printUserCart(int id) throws SQLException;
}
