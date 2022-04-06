
package com.itrail.test.rest;

import com.itrai.test.exception.ItException;
import com.itrail.test.domain.BaseResponce;
import com.itrail.test.domain.OrderRq;
import com.itrail.test.domain.OrderRs;
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
    public BaseResponce getListOrder();

    @POST
    @Path("/{idAnimal}/{idUser}")
    public BaseResponce getBuyAnimal(@PathParam("idAnimal") Integer idAnimal, @PathParam("idUser") Integer idUser) throws ItException;
    
    @POST
    @Path("/orders")
    public OrderRs getOrder(OrderRq req) throws ItException;
    
}
