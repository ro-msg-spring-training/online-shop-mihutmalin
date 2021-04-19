package ro.msg.learning.shop.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.Entities.Address;
import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InputDTO {
    private Date createDate;
    private AddressDTO addressDTO;
    private List<ProductIdAndQuantityDTO> products;
    private Long customerId;
}
