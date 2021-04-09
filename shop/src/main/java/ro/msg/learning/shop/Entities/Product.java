package ro.msg.learning.shop.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Product extends Base{
    private String name;
    private String description;
    private int price;
    private int weight;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "category")
    private ProductCategory category;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "supplier")
    private Supplier supplier;

    private String imageUrl;
}
