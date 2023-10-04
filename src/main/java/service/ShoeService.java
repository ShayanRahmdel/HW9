package service;

import base.service.BaseService;
import entity.Shoe;

import java.sql.SQLException;

public interface ShoeService extends BaseService<Integer, Shoe> {

    void decreaseItem(int id) throws SQLException;

    boolean checkStock(int id) throws SQLException;
}
