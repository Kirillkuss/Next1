
package com.itrail.test.rest;

import com.itrai.test.exception.ItException;
import com.itrail.test.domain.BaseResponse;
import com.itrail.test.domain.Order;
import com.itrail.test.domain.OrderRequest;
import com.itrail.test.domain.OrderResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author barysevich_k
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BuyResource {
    
    @GET
    public BaseResponse getListOrder();

    @POST
    @Path("/{idAnimal}/{idUser}")
    public BaseResponse getBuyAnimal(@PathParam("idAnimal") Integer idAnimal, @PathParam("idUser") Integer idUser) throws ItException;
    
    @POST
    @Path("/order")
    public Order getOrder(OrderRequest req) throws ItException;
    
    @POST
    @Path("/orders")
    public OrderResponse getOrders(OrderRequest req) throws ItException;
    
    
}
