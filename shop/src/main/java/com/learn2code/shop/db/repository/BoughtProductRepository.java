package com.learn2code.shop.db.repository;

import com.learn2code.shop.db.mapper.BoughtProductRowMapper;
import com.learn2code.shop.domain.BoughtProduct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BoughtProductRepository {
    private JdbcTemplate jdbcTemplate;
    private BoughtProductRowMapper boughtProductRowMapper = new BoughtProductRowMapper();

    public BoughtProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(BoughtProduct boughtProduct){
        final String sql = "INSERT INTO bought_product (product_id,customer_id,quantity,bought_at) values (?,?,?,?)";

        jdbcTemplate.update(sql,
                boughtProduct.getProductId(),
                boughtProduct.getCustomerId(),
                boughtProduct.getQuantity(),
                boughtProduct.getBoughtAt());
    }

    public List<BoughtProduct> getAll(int customerId){
        final String sql = "SELECT * FROM bought_product WHERE customer_id = " + customerId;

        return jdbcTemplate.query(sql,boughtProductRowMapper);
    }
}
