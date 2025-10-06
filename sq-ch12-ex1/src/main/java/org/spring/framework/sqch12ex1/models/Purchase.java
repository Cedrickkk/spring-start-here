package org.spring.framework.sqch12ex1.models;

import java.math.BigDecimal;

public class Purchase {
    private int id;
    private String product;
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", price=" + price +
                '}';
    }
}
