package repository;

import base.repository.BaseRepository;
import entity.Shoe;

import java.sql.SQLException;

public interface ShoeRepository extends BaseRepository<Integer, Shoe> {


    int decreaseItem(int id) throws SQLException;

    int checkStock(int id) throws SQLException;
}
