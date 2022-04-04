
package com.itrail.test.rest;

import com.itrail.test.domain.BaseResponce;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Asus
 */
public interface BuyResource {
    
    @POST
    @Path("/{idAnimal}/{idUser}")
    public BaseResponce getAnimalUser(@PathParam("idAnimal") Integer idAnimal, @PathParam("idUser") Integer idUser);
    
}
