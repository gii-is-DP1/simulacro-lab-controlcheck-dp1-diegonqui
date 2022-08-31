package org.springframework.samples.petclinic.product;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseEntity{

    @Size(min = 3, max = 50)
    @NotNull
    private String name;

    @PositiveOrZero
    @NotNull
    private double price;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType productType;
}
