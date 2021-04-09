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
@EqualsAndHashCode(callSuper = true)
public class OrderDetail extends Base{
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "order")
    private Order order;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "product")
    private Product product;

    private int quantity;
}
