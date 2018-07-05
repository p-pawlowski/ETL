package etl.demo.dao;

import etl.demo.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Integer> {

    List<Client> findAll();
}
