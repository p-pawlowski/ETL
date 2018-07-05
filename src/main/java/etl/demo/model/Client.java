package etl.demo.model;

import javax.persistence.*;

@Entity
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_dwh")
    private Integer idDwh;

    @Column(name = "name")
    private String name;

    @Column(name = "flg_del")
    private boolean flgDel;

    public Client(ClientDW clientDwh) {
        this.idDwh = clientDwh.getId();
        this.name = clientDwh.getName();
        this.flgDel = false;
    }

    public Client() {
    }

    public Integer getIdDwh() {
        return idDwh;
    }

    public void setIdDwh(Integer idDwh) {
        this.idDwh = idDwh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlgDel() {
        return flgDel;
    }

    public void setFlgDel(boolean flgDel) {
        this.flgDel = flgDel;
    }

    public void setAll(ClientDW clientDwh) {
        this.name = clientDwh.getName();
        this.flgDel = false;
    }

    ;


}
