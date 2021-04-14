package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class StockId implements Serializable {
    private Long idProduct;
    private Long idLocation;
}
