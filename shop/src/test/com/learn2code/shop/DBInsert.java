package com.learn2code.shop;

import com.learn2code.shop.domain.Customer;
import com.learn2code.shop.domain.Merchant;
import com.learn2code.shop.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional //pre každú testovaciu triedu sa nám vyprázdni naša H2 databáza - pokiaľ by som to nenastavil a púšťal by som viacero testov naraz tak by mohla nastať chyba, pretože niektoprý z testov môže očakávať prázdnu DB, ktor=a ale nie je prázdna
public class DBInsert {
    private final String insertProduct = "INSERT INTO product (merchant_id, name, description, price, created_at, available) VALUES (?, ?, ?, ?, ?, ?)";
    private final String insertMerchant = "INSERT INTO merchant (name, email, address) VALUES (?, ?, ?)";
    private final String insertCustomer = "INSERT INTO customer (name, surname, email, address, age, phone_number) VALUES (?, ?, ?, ?, ?, ?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void createMerchant(){
        Merchant merchant = new Merchant();

        merchant.setName("name");
        merchant.setEmail("email");
        merchant.setAddress("address");

        //blok kódu na vloženie dát do našej DB
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(insertMerchant);
                ps.setString(1,merchant.getName());
                ps.setString(2,merchant.getEmail());
                ps.setString(3,merchant.getAddress());

                return ps;
            }
        });
    }

    @Test
    public void createProduct(){
        Product product = new Product();

        product.setMerchantId(0);
        product.setName("name");
        product.setDescription("description");
        product.setPrice(100);
        product.setCreateAt(Timestamp.from(Instant.now()));
        product.setAvailable(1);

        //blok kódu na vloženie dát do našej DB
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(insertProduct);
                ps.setInt(1,product.getMerchantId());
                ps.setString(2,product.getName());
                ps.setString(3,product.getDescription());
                ps.setDouble(4,product.getPrice());
                ps.setTimestamp(5,product.getCreateAt());
                ps.setInt(6,product.getAvailable());

                return ps;
            }
        });
    }

    @Test
    public void createCustomer(){
        Customer customer = new Customer();

        customer.setName("name");
        customer.setSurname("surname");
        customer.setAddress("address");
        customer.setAge(25);
        customer.setEmail("email");
        customer.setPhoneNumber("phoneNumber");

        //blok kódu na vloženie dát do našej DB
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(insertCustomer);
                ps.setString(1,customer.getName());
                ps.setString(2,customer.getSurname());
                ps.setString(3,customer.getEmail());
                ps.setString(4,customer.getAddress());
                ps.setInt(5,customer.getAge());
                ps.setString(6,customer.getPhoneNumber());

                return ps;
            }
        });
    }
}
