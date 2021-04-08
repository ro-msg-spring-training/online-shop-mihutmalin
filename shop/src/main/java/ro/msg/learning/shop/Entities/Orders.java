package ro.msg.learning.shop.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "ID_location")
    private int idLocation;

    @Column(name = "ID_customer")
    private int idCustomer;

    @Column(name = "CreateDate")
    private int createDate;

    @Column(name = "Country")
    private String country;

    @Column(name = "City")
    private String city;

    @Column(name = "County")
    private String county;

    @Column(name = "StreetAddress")
    private String streetAddress;

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

    public int getIdCustomer() {
        return this.idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(int createDate) {
        this.createDate = createDate;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return this.county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
}
