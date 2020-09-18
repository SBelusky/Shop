//@Nullable pre id -> pri vytváraní inštancie triedy, nepoznáme aké má byť id. Preto zadáme nullable. Naša DB bude vytvárať id
//merchantId nie je Nullable -> pretože pri vytváraní product-u musíme poznať merchant-a
//createAt v konštruktori -> zapíšeme čas vytvorenia inštancie triedy

package com.learn2code.shop.domain;

import com.learn2code.shop.db.service.api.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

public class Product {
    @Nullable
    private Integer id;
    @NonNull
    private Merchant merchant;
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

    public Product(@Nullable Integer id, @NonNull Merchant merchant, @NonNull String name, @NonNull String description, double price, int available) {
        this.id = id;
        this.merchant = merchant;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createAt = Timestamp.from(Instant.now());
        this.available = available;
    }

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
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

    @NonNull
    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(@NonNull Merchant merchant) {
        this.merchant = merchant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                available == product.available &&
                Objects.equals(id, product.id) &&
                merchant.equals(product.merchant) &&
                name.equals(product.name) &&
                description.equals(product.description) &&
                Objects.equals(createAt, product.createAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, merchant, name, description, price, createAt, available);
    }
}
