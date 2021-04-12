package ro.msg.learning.shop.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private Long idCategory;
    private String nameCategory;
    private String descriptionCategory;

    private Long idSupplier;
    private String nameSupplier;

    private String imageUrl;
}
