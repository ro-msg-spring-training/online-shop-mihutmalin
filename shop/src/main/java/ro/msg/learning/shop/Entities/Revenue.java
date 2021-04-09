package ro.msg.learning.shop.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "Revenue")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Revenue extends Base{
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "idLocation")
    private Location location;

    private java.sql.Date date;
    private int sum;
}
