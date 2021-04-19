package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
public class Address extends Base{
    private String country;
    private String city;
    private String county;
    private String streetAddress;
}
