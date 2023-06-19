package com.newjavaapiproject.newjavaapiproject.repository.entity;

import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product", schema = "stock_management")

public class Product {
    @Id // burda key verdi
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // bu anatasyon primary key değerlerinin hangi strateji ile
                                                        // oluşturulacağını belir // 1 er 1 er identity
    private long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantitiy")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Builder.Default // burada construtor da herzaman default olarak geçecek
    @Column(name = "product_updated_date")
    @Temporal(TemporalType.TIMESTAMP) // TemporalType.TIMESTAMP parametresi, bir veritabanı alanının tam tarih ve saat
    @JsonFormat(pattern = "yyyy-MM-dd") // değerini temsil ettiğini belirtir.
    private Date productUpdatedDate = new Date(); // buranın amacı log tutmak

    @Builder.Default
    @Column(name = "product-created-data")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date productCreatedDate = new Date();

    @Column(name = "is_deleted")
    private boolean deleted;

}
