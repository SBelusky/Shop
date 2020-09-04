package com.learn2code.shop.db.mapper;

import com.learn2code.shop.domain.Merchant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MerchantRowMapper implements RowMapper<Merchant> {
    @Override
    public Merchant mapRow(ResultSet rs, int rowNum) throws SQLException {
        Merchant merchant = new Merchant();

        merchant.setId(rs.getInt("id"));
        merchant.setAddress(rs.getString("address"));
        merchant.setEmail(rs.getString("email"));
        merchant.setName(rs.getString("name"));

        return merchant;
    }
}
