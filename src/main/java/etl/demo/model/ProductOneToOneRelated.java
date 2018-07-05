package etl.demo.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "Product_One_To_One_Related")
public class ProductOneToOneRelated {

    @Id
    @Column(name = "ID_PRODUCT")
    private BigInteger id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId("id")
    @JoinColumn(name = "ID_PRODUCT", nullable = false, updatable = false)
    Product product;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
