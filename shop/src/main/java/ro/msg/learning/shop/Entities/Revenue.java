package ro.msg.learning.shop.Entities;
import javax.persistence.*;

@Entity
@Table(name = "Revenue")
public class Revenue {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "ID_location")
    private int idLocation;

    @Column(name = "Date")
    private java.sql.Date date;

    @Column(name = "Sum")
    private int sum;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLocation() {
        return this.idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public java.sql.Date getDate() {
        return this.date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public int getSum() {
        return this.sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
