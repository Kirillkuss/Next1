
package com.itrail.test.domain;

import java.util.List;
/**
 * @author barysevich_k
 */
public class OrderRs {
    private List<Order> orders;

    public OrderRs() {
    }
    
    public OrderRs(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
