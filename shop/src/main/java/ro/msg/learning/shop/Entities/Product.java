package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
public class Product extends Base{
    private String name;
    private String description;
    private int price;
    private int weight;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "idCategory")
    private ProductCategory category;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "idSupplier")
    private Supplier supplier;

    private String imageUrl;
}
