package service.impel;

import base.service.impel.BaseServiceImpl;
import entity.Electronic;
import repository.ElecRepository;
import service.ElectronicService;

import java.sql.SQLException;

public class ElectronicServiceImpl extends BaseServiceImpl<Integer, Electronic, ElecRepository> implements ElectronicService {
    private ElecRepository elecRepository;

    public ElectronicServiceImpl(ElecRepository repository) {
        super(repository);
        this.elecRepository = repository;
    }

    @Override
    public void decreaseItem(int id) throws SQLException {
        repository.decreaseItem(id);
    }

    @Override
    public boolean checkStock(int id) throws SQLException {
        if (elecRepository.checkStock(id) == 0) {
            return true;
        } else return false;
    }

}
