package etl.demo.dao;

import etl.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ProductRepository extends JpaRepository<Product, BigInteger> {

    @Modifying
    @Query("update Product p1 set p1.contractNumber = :#{#p.contractNumber} where p1.id = :#{#p.id}")
    void update(@Param("p")Product product);
}
