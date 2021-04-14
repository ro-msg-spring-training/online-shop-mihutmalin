package ro.msg.learning.shop.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StrategyDTO {
    private LocationDTO location;
    private ProductDTO product;
    private int quantity;
}
