package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "OrderDetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
@Builder
public class OrderDetail{
    @EmbeddedId
    private OrderDetailId orderDetailId;

    @ManyToOne(fetch= FetchType.LAZY)
    @MapsId("idOrder")
    @JoinColumn(name = "idOrder")
    private Order order;

    @ManyToOne(fetch= FetchType.LAZY)
    @MapsId("idProduct")
    @JoinColumn(name = "idProduct")
    private Product product;

    private int quantity;
}
