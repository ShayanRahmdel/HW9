package service;

import base.service.BaseService;
import entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService extends BaseService<Integer, Product> {

    int checkStock(int id) throws SQLException;

    void decrease(int id) throws SQLException;

    void increase(int id) throws SQLException;
}
