package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "Customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
public class Customer extends Base{
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String emailAddress;
}
