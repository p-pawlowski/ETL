package etl.demo.service;

import etl.demo.dao.ProductRepository;
import etl.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Transactional
    public void update(Product produt){
        productRepository.update(produt);
    }

}
