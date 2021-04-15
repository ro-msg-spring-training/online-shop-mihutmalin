package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "stock")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
@Builder
public class Stock{
    @EmbeddedId
    private StockId id;

    @ManyToOne(fetch= FetchType.LAZY)
    @MapsId("idProduct")
    @JoinColumn(name = "idProduct")
    private Product product;

    @ManyToOne(fetch= FetchType.LAZY)
    @MapsId("idLocation")
    @JoinColumn(name = "idLocation")
    private Location location;

    private int quantity;
}
