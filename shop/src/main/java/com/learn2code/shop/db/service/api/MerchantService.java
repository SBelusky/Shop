package com.learn2code.shop.db.service.api;

import com.learn2code.shop.domain.Merchant;
import org.springframework.lang.Nullable;

import java.util.List;

public interface MerchantService {
    List<Merchant> getMerchants();

    @Nullable
    Merchant get(int id);

    @Nullable //pokiaľ by nastala chyba tak sa vráti null
    Integer add(Merchant merchant); //po vytvorení customera, vráti metóda id  z databázy
}
