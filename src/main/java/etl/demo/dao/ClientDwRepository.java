package etl.demo.dao;

import etl.demo.model.ClientDW;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientDwRepository extends CrudRepository<ClientDW, Integer> {

    List<ClientDW> findAll();
}
