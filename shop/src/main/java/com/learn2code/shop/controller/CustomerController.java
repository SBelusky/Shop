package com.learn2code.shop.controller;

import com.learn2code.shop.db.service.api.CustomerAccountService;
import com.learn2code.shop.db.service.api.CustomerService;
import com.learn2code.shop.domain.Customer;
import com.learn2code.shop.domain.CustomerAccount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerAccountService customerAccountService;

    public CustomerController(CustomerService customerService, CustomerAccountService customerAccountService) {
        this.customerService = customerService;
        this.customerAccountService = customerAccountService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Customer customer) { //@RequestBody -> telo requestu bude pretransformované do objektu customer
        Integer id = customerService.add(customer);
        if (id != null){
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable("id") int id) { //@PathVariable -> vytiahne hodnotu id z requestu (z URL)
        Customer customer = customerService.get(id);
        if (customer == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:8081")
    public ResponseEntity getAll() {
        List<Customer> customerList = customerService.getCustomers();

        return new ResponseEntity<>(customerList, HttpStatus.OK); //metóda mi vráti zoznam customerov so statusom OK -> každý respond obsahuje v sebe status; pokiaľ by som vybral status NOT_FOUND tak respond bude v tomto stave
    }

    @PostMapping("/account")
    public ResponseEntity addAccount(@RequestBody CustomerAccount customerAccount) {
        customerAccountService.add(customerAccount);

        return ResponseEntity.status(HttpStatus.OK).body("Účet bol úspešne vytvorený");
    }
}
