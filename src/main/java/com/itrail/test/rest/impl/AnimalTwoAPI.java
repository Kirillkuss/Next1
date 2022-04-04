
package com.itrail.test.rest.impl;

import com.itrail.test.domain.BaseResponce;
import com.itrail.test.rest.AnimalResourceTwo;
import com.itrail.test.service.AnimalServiceTwo;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author barysevich_k
 */

@Path("animalEM")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AnimalTwoAPI implements AnimalResourceTwo{
    
    @EJB private AnimalServiceTwo service;

    @Override
    public BaseResponce getAnimalByList() {
        BaseResponce bs = new BaseResponce(200, "success");
        bs.setData(service.getAnimalByList());
        return bs;
        
    }

    @Override
    public BaseResponce getAnimalById(Integer idAnimal) {
        BaseResponce bs = new BaseResponce(200, "success");
        bs.setData(service.getAnimalById(idAnimal));
        return bs;
    }

    @Override
    public BaseResponce getWithoutOwner() {
        BaseResponce bs = new BaseResponce(200, "success");
        bs.setData(service.withoutOwner());
        System.out.println("WithoutOWNER>>> " + service.withoutOwner());
        return bs;
    }
    
    
    
    
    
}
