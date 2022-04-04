
package com.itrail.test.rest.impl;

import com.itrail.test.domain.BaseResponce;
import com.itrail.test.rest.BuyResource;
import com.itrail.test.service.BuyService;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author barysevich_k
 */

@Path("em")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BuyAPI implements BuyResource {
        @EJB private BuyService ser;

    @Override
    public BaseResponce getAnimalUser(Integer idAnimal, Integer idUser) {
        BaseResponce bs = new BaseResponce(200, "success");
        ser.getUserAnimal(idAnimal, idUser);
        return bs;
    }
        
 
}
