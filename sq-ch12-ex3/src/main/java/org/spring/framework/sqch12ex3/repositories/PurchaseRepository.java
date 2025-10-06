package org.spring.framework.sqch12ex3.repositories;

import org.spring.framework.sqch12ex3.models.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PurchaseRepository {
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsertToPurchase;

    @Autowired
    public PurchaseRepository(JdbcTemplate jdbcTemplate, SimpleJdbcInsert simpleJdbcInsertToPurchase) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsertToPurchase = simpleJdbcInsertToPurchase;

        this.simpleJdbcInsertToPurchase
                .withTableName("purchase")
                .usingGeneratedKeyColumns("id");
    }

    public List<Purchase> findAll() {
        String sql = "SELECT * FROM purchase";
        RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
            Purchase rowObject = new Purchase();
            rowObject.setId(r.getInt("id"));
            rowObject.setProduct(r.getString("product"));
            rowObject.setPrice(r.getBigDecimal("price"));
            return rowObject;
        };
        return jdbcTemplate.query(sql, purchaseRowMapper);
    }

    public Purchase store(Purchase purchase) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("product", purchase.getProduct());
        parameters.put("price", purchase.getPrice());
        Number generatedId = simpleJdbcInsertToPurchase.executeAndReturnKey(parameters);
        purchase.setId(generatedId.intValue());
        return purchase;
    }
}
