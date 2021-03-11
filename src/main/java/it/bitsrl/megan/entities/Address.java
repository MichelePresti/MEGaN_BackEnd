package it.bitsrl.megan.entities;


import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String streetAddress;
    private String city;
    private String province;
    @Enumerated(EnumType.STRING)
    private Region region;

    @OneToOne(mappedBy="address")
    private Person person;


    public Address(){}

    public Address(String streetAddress, String city, String province, Region region) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.region = region;
    }


}
