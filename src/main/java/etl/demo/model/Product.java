package etl.demo.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.math.BigInteger;

@Table(name = "PRODUCT")
@Entity
public class Product implements Persistable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private BigInteger id;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.ALL}, mappedBy = "product", fetch = FetchType.LAZY)
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

    public boolean isNew() {
        if (this.id == null) {
            return true;
        }
        return false;
    }
}
