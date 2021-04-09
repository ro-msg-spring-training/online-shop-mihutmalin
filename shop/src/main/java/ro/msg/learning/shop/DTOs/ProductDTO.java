package ro.msg.learning.shop.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.Entities.ProductCategory;
import ro.msg.learning.shop.Entities.Supplier;

@Data
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private int price;
    private int weight;
    private ProductCategory category;
    private Supplier supplier;
    private String imageUrl;
}
