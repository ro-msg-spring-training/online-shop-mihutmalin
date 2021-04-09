package ro.msg.learning.shop.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "Order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Order extends Address{
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "shippedFrom")
    private Location shippedFrom;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "customer")
    private Customer customer;

    private int createDate;
}
