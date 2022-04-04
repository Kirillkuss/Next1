
package com.itrail.test.rest;

import com.itrail.test.domain.BaseResponce;
import com.itrail.test.domain.User;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author barysevich_k
 */
public interface UserResourceTwo {
    
    @GET
    public BaseResponce getAllUsers();
    
    @GET
    @Path("/{idUser}")
    public BaseResponce getUserByID(@PathParam("idUser") Integer idUser);
    
    @PUT
    @Path("/create")
    public BaseResponce createUser(User user) ;
    
    @POST
    @Path("/{idUser}/{name}")
    public BaseResponce updateUser(@PathParam("idUser") Integer idUser, @PathParam("name") String name);
    
    @DELETE
    @Path("/{idUser}")
    public BaseResponce deleteUserUM(@PathParam("idUser") Integer idUser);
    

 
}
