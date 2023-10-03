package service.impel;

import base.service.impel.BaseServiceImpl;
import entity.Electronic;
import repository.ElecRepository;
import service.ElectronicService;

public class ElectronicServiceImpl extends BaseServiceImpl<Integer, Electronic, ElecRepository> implements ElectronicService {
    public ElectronicServiceImpl(ElecRepository repository) {
        super(repository);
    }
}
