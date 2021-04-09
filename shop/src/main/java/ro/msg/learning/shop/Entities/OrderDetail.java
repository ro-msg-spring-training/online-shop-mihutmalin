package ro.msg.learning.shop.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "OrderDetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class OrderDetail{
    @EmbeddedId
    private OrderDetailId orderDetailId;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "idOrder")
    private Order order;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "idProduct")
    private Product product;

    private int quantity;
}
