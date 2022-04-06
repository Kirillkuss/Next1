
package com.itrail.test.rest;
import com.itrai.test.exception.ItException;
import com.itrail.test.domain.BaseResponce;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
/**
 *
 * @author barysevich_k
 */
@Consumes({"application/json"})
@Produces({"application/json"})
public interface AnimalResource {
   @GET
    public BaseResponce getAnimal() throws ItException; 
    
    @GET
    @Path("/{idAnimal}")
    public BaseResponce getAnimalID(@PathParam("idAnimal") Integer idAnimal) throws ItException;
    
    
   @GET
   @Path("/sum")
   public BaseResponce sumCoatAni() throws ItException;
   
   @GET
   @Path("/owner/no")
   public BaseResponce withoutOwnerList() throws ItException;
 
   
   @GET
   @Path("/calc/ex")
   public BaseResponce getMyCalc() throws ItException;
   
   @POST
   @Path("/update/{number}")
   public BaseResponce modifyNumber(@PathParam("number") int number);
   
   
}
