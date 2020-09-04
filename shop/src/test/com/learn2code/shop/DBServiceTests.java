package com.learn2code.shop;

import com.learn2code.shop.db.mapper.CustomerRowMapper;
import com.learn2code.shop.db.service.api.CustomerService;
import com.learn2code.shop.db.service.api.MerchantService;
import com.learn2code.shop.db.service.api.ProductService;
import com.learn2code.shop.db.service.api.request.UpdateProductRequest;
import com.learn2code.shop.domain.Customer;
import com.learn2code.shop.domain.Merchant;
import com.learn2code.shop.domain.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional //pre každú testovaciu triedu sa nám vyprázdni naša H2 databáza - pokiaľ by som to nenastavil a púšťal by som viacero testov naraz tak by mohla nastať chyba, pretože niektoprý z testov môže očakávať prázdnu DB, ktor=a ale nie je prázdna
public class DBServiceTests {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private ProductService productService;
    private Merchant merchant;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before //metóda sa spustí vždy pre začiatkom testov
    public void createMerchant(){
        if (this.merchant == null){
            this.merchant = new Merchant("name","email","address");
            Integer id = merchantService.add(merchant);
            assert id != null;
            merchant.setId(id);
        }
    }

    @Test
    public void customer(){
        Customer customer = new Customer("name","surname","email","address",25,"phonenumber");
        Integer id = customerService.add(customer); //funkcia vráti id pridaného customer-a
        assert id != null; //po pridaní customera do DB by nal byť id null
        CustomerRowMapper customerRowMapper = new CustomerRowMapper();
        customer.setId(id);
        Customer fromDB = customerService.get(id);
        Assert.assertEquals(customer,fromDB);

        List<Customer> customers = customerService.getCustomers();
        assert !customers.isEmpty();
        //Assert.assertEquals(1,customers.size());
        Assert.assertEquals(customer,customers.get(0));
    }

    @Test
    public void merchant(){
        //merchant je vytvorený v metode createMerchant
        Merchant fromDB = merchantService.get(merchant.getId());
        Assert.assertEquals(merchant,fromDB);

        List<Merchant> merchants = merchantService.getMerchants();
        assert !merchants.isEmpty();
        Assert.assertEquals(1,merchants.size());
        Assert.assertEquals(merchant,merchants.get(0));
    }

    @Test
    public void product(){
        Product product = new Product(this.merchant.getId(),"name","description",10,1);
        Integer id = productService.add(product);
        assert id != null;
        product.setId(id);

        Product fromDB = productService.get(id);
        Assert.assertEquals(product,fromDB);

        List<Product> products = productService.getProducts();
        assert !products.isEmpty();
        Assert.assertEquals(1,products.size());
        Assert.assertEquals(product,products.get(0));

        product.setAvailable(10);
        UpdateProductRequest updateProductRequest = new UpdateProductRequest(product.getName(),product.getDescription(),product.getPrice(),product.getAvailable());
        productService.update(id, updateProductRequest);
        Product fromDBUpdate = productService.get(id);
        Assert.assertEquals(fromDBUpdate,product);
        Assert.assertNotEquals(fromDB,fromDBUpdate);

        productService.delete(id);
        Assert.assertNotEquals(1,productService.getProducts().size());
    }

}
