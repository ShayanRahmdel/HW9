package repository;

import base.repository.BaseRepository;
import entity.Electronic;
import entity.ElectronicProduct;

import java.sql.SQLException;

public interface ElecRepository extends BaseRepository<Integer, Electronic> {

    int decreaseItem(int id) throws SQLException;

    int checkStock(int id) throws SQLException;
}
