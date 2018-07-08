package etl.demo.controller;

import etl.demo.dao.ClientDwRepository;
import etl.demo.dao.ClientRepository;
import etl.demo.dao.ProductRepository;
import etl.demo.model.Client;
import etl.demo.model.ClientDW;
import etl.demo.model.ProductOneToOneRelated;
import etl.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.transaction.annotation.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/")
public class MainController {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDwRepository clientDwhRepository;

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(path = "main")
    public void doMain() {
        System.out.println("abc");
        Client client = new Client();
        client.setFlagDel(false);
        client.setName("trzeci");

        Client client1 = clientRepository.save(client);
        System.out.println(client1.getId());

        List<Client> clients = clientRepository.findAll();

        for (Client p : clients) {
            p.setFlagDel(true);
            clientRepository.save(p);
        }
    }

    @RequestMapping(path = "dwh")
    public void doClientDwh() {

        List<Client> clients = clientRepository.findAll();
        clients.stream().forEach(c -> c.setFlagDel(true));
        List<ClientDW> clientsDwh = clientDwhRepository.findAll();

        for (ClientDW clientDwh : clientsDwh) {
            Optional<Client> opClient = clients.stream().filter(c -> c.getId().equals(clientDwh.getId())).findFirst();
            if (opClient.isPresent()) {
                opClient.get().setAll(clientDwh);
            } else {
                clients.add(new Client(clientDwh));
            }
        }
//        clientRepository.saveAll(clients);

        clientRepository.save(clients.get(0));
    }

    @Transactional
    @RequestMapping(path = "product")
    public void product() {
        Product product1 = new Product();
        product1.setId(BigInteger.valueOf(1l));
        product1.setContractNumber(BigInteger.ZERO);


        productRepository.update(product1);
    }

    @RequestMapping(path="getProduct")
    public void getProduct(){
        List<Product> products = productRepository.findAll();
        ProductOneToOneRelated productOneToOneRelated = products.get(1).getProductOneToOneRelated();
        System.out.println(productOneToOneRelated.getDescription());
    }

}
