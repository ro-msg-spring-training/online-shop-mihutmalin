package ro.msg.learning.shop.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "Stock")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class Stock{
    @EmbeddedId
    private StockId id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "idProduct")
    private Product product;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "idLocation")
    private Location location;

    private int quantity;
}
