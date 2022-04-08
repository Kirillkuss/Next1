
package com.itrail.test.rest;

import com.itrail.test.domain.BaseResponse;
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
    public BaseResponse getAnimalByList();
    
    @GET
    @Path("/{idAnimal}")
    public BaseResponse getAnimalById(@PathParam("idAnimal") Integer idAnimal);
    
    @GET
    @Path("/owner/no")
    public BaseResponse getWithoutOwner();
    
}
