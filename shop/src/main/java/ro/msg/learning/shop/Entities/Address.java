package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Address extends Base{
    private String country;
    private String city;
    private String county;
    private String streetAddress;
}
