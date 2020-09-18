package com.learn2code.shop.db.mapper;

import com.learn2code.shop.db.service.api.MerchantService;
import com.learn2code.shop.db.service.api.ProductService;
import com.learn2code.shop.domain.Merchant;
import com.learn2code.shop.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    public ProductRowMapper() {
    }

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();

        product.setId(rs.getInt("product_id"));

        product.setMerchant(new Merchant(
                rs.getInt("merchant_id"),
                rs.getString("merchant_name"),
                rs.getString("merchant_email"),
                rs.getString("merchant_address")

        ));
        product.setName(rs.getString("product_name"));
        product.setDescription(rs.getString("product_description"));
        product.setPrice(rs.getDouble("product_price"));
        product.setCreateAt(rs.getTimestamp("product_created_at"));
        product.setAvailable(rs.getInt("product_available"));

        return product;
    }
}
