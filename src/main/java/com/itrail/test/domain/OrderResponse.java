
package com.itrail.test.domain;

import java.util.List;
/**
 * @author barysevich_k
 */
public class OrderResponse {
    private List<Order> orders;

    public OrderResponse() {
    }
    
    public OrderResponse(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
