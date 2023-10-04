package repository;

import base.repository.BaseRepository;
import entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ProductRepository extends BaseRepository<Integer, Product> {

    int checkStock(int id) throws SQLException;

    void decrease(int id) throws SQLException;

    void increase(int id) throws SQLException;
}
