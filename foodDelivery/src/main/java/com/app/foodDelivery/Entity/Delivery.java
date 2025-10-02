package com.app.foodDelivery.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.source.doctree.EscapeTree;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;
    private String deliveryStatus;
    private String deliveryAddress;
    private String deliveryPerson;

    @OneToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;

}
