package br.desoftware.ecommerce.checkout.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Builder
public class CheckoutEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String code;
}
