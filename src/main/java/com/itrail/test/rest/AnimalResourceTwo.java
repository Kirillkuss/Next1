
package com.itrail.test.rest;

import com.itrail.test.domain.BaseResponce;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
public interface AnimalResourceTwo {
    
    @GET
    public BaseResponce getAnimalByList();
    
    @GET
    @Path("/{idAnimal}")
    public BaseResponce getAnimalById(@PathParam("idAnimal") Integer idAnimal);
    
    @GET
    @Path("/owner/no")
    public BaseResponce getWithoutOwner();
    
}
