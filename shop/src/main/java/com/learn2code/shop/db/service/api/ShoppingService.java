// interface pre reprezentáciu kúpy tovaru zákazníkom
package com.learn2code.shop.db.service.api;

import com.learn2code.shop.db.service.api.request.BuyProductRequest;
import com.learn2code.shop.db.service.api.response.BuyProductResponse;

public interface ShoppingService {
    BuyProductResponse buyProduct(BuyProductRequest request);
}
