package com.learn2code.shop.db.service.api;

import com.learn2code.shop.domain.BoughtProduct;

import java.util.List;

public interface BoughtProductService {
    void add(BoughtProduct boughtProduct);

    List<BoughtProduct> getAll(int customerId);
}
