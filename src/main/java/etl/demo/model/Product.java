package etl.demo.model;

import javax.persistence.*;
import java.math.BigInteger;

@Table(name = "PRODUCT")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private BigInteger id;

    @Column(name="CONTRACT_NUMBER")
    private BigInteger contractNumber;

    @Transient
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.ALL}, mappedBy = "product", fetch = FetchType.LAZY)
    private ProductOneToOneRelated productOneToOneRelated;

    public BigInteger getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(BigInteger contractNumber) {
        this.contractNumber = contractNumber;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public ProductOneToOneRelated getProductOneToOneRelated() {
        return productOneToOneRelated;
    }

    public void setProductOneToOneRelated(ProductOneToOneRelated productOneToOneRelated) {
        this.productOneToOneRelated = productOneToOneRelated;
    }

}
