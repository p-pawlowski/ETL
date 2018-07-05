package etl.demo.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Entity
@Table
public class Client implements Persistable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "del_flag")
    private boolean flagDel;

    public Client(ClientDW clientDw) {
        this.id = clientDw.getId();
        this.name = clientDw.getName();
        this.flagDel = false;
    }

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlagDel() {
        return flagDel;
    }

    public void setFlagDel(boolean flagDel) {
        this.flagDel = flagDel;
    }

    public void setAll(ClientDW clientDwh) {
        this.name = clientDwh.getName();
        this.flagDel = false;
    }

    public boolean isNew() {
        if (this.id == null) {
            return true;
        }
        return false;
    }


}
