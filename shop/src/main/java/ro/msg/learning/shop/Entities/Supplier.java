package ro.msg.learning.shop.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Supplier")
public class Supplier {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "Name")
    private String name;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
