package ro.msg.learning.shop.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.Entities.ProductCategory;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private int price;
    private int weight;
    private ProductCategoryDTO productCategory;
    private SupplierDTO supplier;
    private String imageUrl;
}
