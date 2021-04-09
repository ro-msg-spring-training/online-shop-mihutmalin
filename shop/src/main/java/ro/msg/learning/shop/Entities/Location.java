package ro.msg.learning.shop.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "Location")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Location extends Base{
    private String name;

    @OneToOne
    @JoinColumn(name = "Address")
    private Address address;
}
