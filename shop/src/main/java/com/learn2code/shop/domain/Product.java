//@Nullable pre id -> pri vytváraní inštancie triedy, nepoznáme aké má byť id. Preto zadáme nullable. Naša DB bude vytvárať id
//merchantId nie je Nullable -> pretože pri vytváraní product-u musíme poznať merchant-a
//createAt v konštruktori -> zapíšeme čas vytvorenia inštancie triedy

package com.learn2code.shop.domain;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

public class Product {
    @Nullable
    private Integer id;
    @NonNull
    private int merchantId;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private double price;
    @Nullable
    private Timestamp createAt;
    @NonNull
    private int available;

    public Product() {
    }

    public Product(int merchantId, @NonNull String name, @NonNull String description, double price, int available) {
        this.merchantId = merchantId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
        this.createAt = Timestamp.from(Instant.now());
    }

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Nullable
    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(@NonNull Timestamp createAt) {
        this.createAt = createAt;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return merchantId == product.merchantId &&
                Double.compare(product.price, price) == 0 &&
                available == product.available &&
                Objects.equals(id, product.id) &&
                name.equals(product.name) &&
                description.equals(product.description) &&
                createAt.getTime() == product.getCreateAt().getTime();


    }

    @Override
    public int hashCode() {
        return Objects.hash(id, merchantId, name, description, price, createAt, available);
    }
}
