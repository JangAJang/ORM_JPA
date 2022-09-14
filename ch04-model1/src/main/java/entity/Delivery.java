package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "DELIVERY")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DELIVERY_ID")
    private Long id;

    @Column(name = "DELIVERY_CITY")
    private String city;

    @Column(name = "DELIVERY_ZIPCODE")
    private String zipcode;

    @OneToOne(mappedBy = "delivery")
    private Orders orders;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
}
