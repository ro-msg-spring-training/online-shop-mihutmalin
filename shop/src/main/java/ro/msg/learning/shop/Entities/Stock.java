package ro.msg.learning.shop.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Stock")
public class Stock {
    @Column(name = "ID_product")
    private int idProduct;

    @Column(name = "ID_location")
    private int idLocation;

    @Column(name = "Quantity")
    private int quantity;

    public int getIdProduct() {
        return this.idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdLocation() {
        return this.idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
