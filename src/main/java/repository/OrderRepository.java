package repository;

import base.repository.BaseRepository;
import entity.Order;

public interface OrderRepository extends BaseRepository<Integer, Order> {

    double sumPrize();
}
