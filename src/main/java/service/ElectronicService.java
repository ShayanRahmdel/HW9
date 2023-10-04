package service;

import base.service.BaseService;
import entity.Electronic;

import java.sql.SQLException;

public interface ElectronicService extends BaseService<Integer, Electronic> {

    void decreaseItem(int id) throws SQLException;

    boolean checkStock(int id) throws SQLException;
}
