package com.learn2code.shop.controller;

import com.learn2code.shop.db.service.api.ProductService;
import com.learn2code.shop.db.service.api.request.UpdateProductRequest;
import com.learn2code.shop.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:8081")
    public ResponseEntity add(@RequestBody Product product) { //@RequestBody -> telo requestu bude pretransformované do objektu customer
        Integer id = productService.add(product);

        if (id != null){
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("{id}")
    @CrossOrigin(origins = "http://localhost:8081")
    public ResponseEntity get(@PathVariable("id") int id) { //@PathVariable -> vytiahne hodnotu id z requestu (z URL)
        Product product = productService.get(id);

        if (product == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:8081")
    public ResponseEntity<?> getAll() {
        List<Product> productList = productService.getProducts();

        return new ResponseEntity<>(productList, HttpStatus.OK); //metóda mi vráti zoznam customerov so statusom OK -> každý respond obsahuje v sebe status; pokiaľ by som vybral status NOT_FOUND tak respond bude v tomto stave
    }

    @PatchMapping("{id}")
    @CrossOrigin(origins = "http://localhost:8081")
    public ResponseEntity update(@PathVariable("id") int id, @RequestBody UpdateProductRequest updateProductRequest) {
        if (productService.get(id) != null){
            productService.update(id, updateProductRequest);
            return new ResponseEntity(HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.PRECONDITION_FAILED);
        }
    }

    @DeleteMapping("{id}")
    @CrossOrigin(origins = "http://localhost:8081")
    public ResponseEntity delete(@PathVariable("id") int id) {
        if (productService.get(id) != null) {
            productService.delete(id);

            return ResponseEntity.status(HttpStatus.OK)
                    .body("Produkt s id " + id + " bol vymazaný");
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.PRECONDITION_REQUIRED)
                    .body("Produkt s id " + id + " neexistuje !");
        }

    }
}
