package com.learn2code.shop.db.service.api;

import com.learn2code.shop.domain.CustomerAccount;
import org.springframework.lang.Nullable;

public interface CustomerAccountService {
    void add(CustomerAccount customerAccount);

    @Nullable
    Double getMoney(int customerId);

    void setMoney(int customerId, double money);
}
