package com.learn2code.shop.db.service.impl;

import com.learn2code.shop.db.repository.BoughtProductRepository;
import com.learn2code.shop.db.service.api.BoughtProductService;
import com.learn2code.shop.domain.BoughtProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoughtProductServiceImpl implements BoughtProductService {
    private final BoughtProductRepository boughtProductRepository;

    public BoughtProductServiceImpl(BoughtProductRepository boughtProductRepository) {
        this.boughtProductRepository = boughtProductRepository;
    }

    @Override
    public void add(BoughtProduct boughtProduct) {
        boughtProductRepository.add(boughtProduct);
    }

    @Override
    public List<BoughtProduct> getAll(int customerId) {
        return boughtProductRepository.getAll(customerId);
    }
}
