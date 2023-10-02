package base.service.impel;

import base.entity.BaseEntity;
import base.repository.BaseRepository;
import base.service.BaseService;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class BaseServiceImpl<ID extends Serializable,TYPE extends BaseEntity<ID>,
        R extends BaseRepository<ID,TYPE>>
        implements BaseService<ID,TYPE> {


    protected R userRepository;

    public BaseServiceImpl(R repository) {
        this.userRepository = repository;
    }
    @Override
    public void save(TYPE entity) throws SQLException {
           userRepository.save(entity);
    }

    @Override
    public List<TYPE> findAll() throws SQLException {
        return userRepository.findAll();
    }

    @Override
    public TYPE findById(ID id) throws SQLException {
        return userRepository.findById(id);
    }

    @Override
    public void update(TYPE entity) throws SQLException {
        userRepository.update(entity);
    }

    @Override
    public void delete(ID id) throws SQLException {
            userRepository.delete(id);
    }
}
