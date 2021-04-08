package ro.msg.learning.shop.Entities;

import javax.persistence.*;

@Entity
@Table(name = "OrderDetail")
public class OrderDetail {
    @Column(name = "ID_order")
    private int idOrder;

    @Column(name = "ID_product")
    private int idProduct;

    @Column(name = "Quantity")
    private int quantity;

    public int getIdOrder() {
        return this.idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdProduct() {
        return this.idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
