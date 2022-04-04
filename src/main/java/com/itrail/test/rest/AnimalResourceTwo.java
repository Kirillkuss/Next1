
package com.itrail.test.rest;

import com.itrail.test.domain.BaseResponce;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author barysevich_k
 */
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
