package com.learn2code.shop.db.service.impl;

import com.learn2code.shop.db.service.api.*;
import com.learn2code.shop.db.service.api.request.BuyProductRequest;
import com.learn2code.shop.db.service.api.response.BuyProductResponse;
import com.learn2code.shop.domain.BoughtProduct;
import com.learn2code.shop.domain.Customer;
import com.learn2code.shop.domain.Product;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class ShoppingServiceImpl implements ShoppingService {
    private ProductService productService;
    private CustomerService customerService;
    private CustomerAccountService customerAccountService;
    private BoughtProductService boughtProductService;

    public ShoppingServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public BuyProductResponse buyProduct(BuyProductRequest request) {
        int productId = request.getProductId();
        int customerId = request.getCustomerId();

        Product product = productService.get(productId);
        if (product == null){
            return new BuyProductResponse(false,"Produkt s id " + productId + " neexistuje!");
        }

        Customer customer = customerService.get(customerId);
        if (customer == null){
            return new BuyProductResponse(false,"Zákazník s id " + customerId + " neexistuje!");
        }

        if (product.getAvailable() < request.getQuantity()){
            return new BuyProductResponse(false,"Produkt s id " + productId + " nie je dostupný v požadovanej kvantite");
        }

        Double customerMoney = customerAccountService.getMoney(customerId);
        if (customerMoney == null){
            return new BuyProductResponse(false,"Zákazník s id " + customerId + " nemá založený účet");
        }
        else{
            double totalPriceOfRequest = request.getQuantity() * product.getPrice();
            if (customerMoney >= totalPriceOfRequest){
                customerAccountService.setMoney(customerId, customerMoney - totalPriceOfRequest);
                productService.updateAvailableInternal(productId, product.getAvailable()-request.getQuantity());
                boughtProductService.add(new BoughtProduct(productId,customerId,request.getQuantity()));

                return new BuyProductResponse(true,"Kúpa prebehla uspešne");
            }
            else{
                return new BuyProductResponse(false,"Zákazník s id " + customerId + " nemá dostatočné množstvo peňazí");
            }
        }

    }
}
