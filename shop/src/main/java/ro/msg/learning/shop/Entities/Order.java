package ro.msg.learning.shop.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Order extends Base{
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "idLocation")
    private Location shippedFrom;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "idCustomer")
    private Customer customer;

    private Date createDate;

    @OneToOne
    @JoinColumn(name = "Address")
    private Address address;
}
