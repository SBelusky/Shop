package com.learn2code.shop.controller;

import com.learn2code.shop.db.service.api.MerchantService;
import com.learn2code.shop.db.service.api.ProductService;
import com.learn2code.shop.domain.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;

import java.util.List;

@RestController
@RequestMapping("merchant")
public class MerchantController {
    private final MerchantService merchantService;
    @Autowired
    ProductService productService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Merchant merchant){ //@RequestBody -> telo requestu bude pretransformované do objektu customer
        Integer id = merchantService.add(merchant);

        if (id != null){
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable("id") int id){ //@PathVariable -> vytiahne hodnotu id z requestu (z URL)
        Merchant merchant = merchantService.get(id);

        if (merchant == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(merchant, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity getAll(){
        List<Merchant> merchantList = merchantService.getMerchants();

        return new ResponseEntity<>(merchantList, HttpStatus.OK); //metóda mi vráti zoznam customerov so statusom OK -> každý respond obsahuje v sebe status; pokiaľ by som vybral status NOT_FOUND tak respond bude v tomto stave
    }
}
