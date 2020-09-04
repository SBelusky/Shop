//@Nullable metóda get() -> pretože táto metóda može hladať aj customera, ktorý neexistuje - v takom prípade metóda vráti NULL

package com.learn2code.shop.db.service.api;

import com.learn2code.shop.domain.Customer;
import org.springframework.lang.Nullable;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    @Nullable
    Customer get(int id);

    @Nullable //pokiaľ by nastala chyba tak sa vráti null
    Integer add(Customer customer); //po vytvorení customera, vráti metóda id  z databázy
}
