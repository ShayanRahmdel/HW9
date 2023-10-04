package service.impel;

import base.service.impel.BaseServiceImpl;
import entity.Shoe;
import repository.ShoeRepository;
import service.ShoeService;

import java.sql.SQLException;

public class ShoeServiceImpl extends BaseServiceImpl<Integer, Shoe, ShoeRepository> implements ShoeService {

    private ShoeRepository shoeRepository;

    public ShoeServiceImpl(ShoeRepository repository) {
        super(repository);
        this.shoeRepository = repository;
    }

    @Override
    public void decreaseItem(int id) throws SQLException {
        shoeRepository.decreaseItem(id);
    }

    @Override
    public boolean checkStock(int id) throws SQLException {
        if (shoeRepository.checkStock(id) == 0) {
            return true;
        } else return false;
    }
}
