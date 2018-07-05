package etl.demo.model;

import javax.persistence.*;
import java.math.BigInteger;

@Table(name="PRODUCT")
@Entity
public class Product {

    @Id
    @Column(name="ID")
    private BigInteger id;

    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "product", fetch = FetchType.LAZY)
    private ProductOneToOneRelated productOneToOneRelated;

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