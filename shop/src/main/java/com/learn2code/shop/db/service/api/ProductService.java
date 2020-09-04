package com.learn2code.shop.db.service.api;

import com.learn2code.shop.db.service.api.request.UpdateProductRequest;
import com.learn2code.shop.domain.Product;
import org.springframework.lang.Nullable;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    @Nullable
    Product get(int id);

    @Nullable //pokiaľ by nastala chyba tak sa vráti null
    Integer add(Product product); //po vytvorení product-u, vráti metóda id  z databázy

    void delete(int id);

    void update(int id, UpdateProductRequest request);
}
