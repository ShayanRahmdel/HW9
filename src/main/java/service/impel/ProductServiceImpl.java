package service.impel;

import base.service.impel.BaseServiceImpl;
import entity.Product;
import repository.ProductRepository;
import service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl extends BaseServiceImpl<Integer, Product, ProductRepository> implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository repository) {
        super(repository);
        this.productRepository = repository;
    }


    @Override
    public int checkStock(int id) throws SQLException {
        int result = repository.checkStock(id);
        return result;
    }

    @Override
    public void decrease(int id) throws SQLException {
        repository.decrease(id);
    }

    @Override
    public void increase(int id) throws SQLException {
        repository.increase(id);
    }

    @Override
    public boolean checkId(int id) throws SQLException {
        return id==repository.checkID(id);
    }


}
