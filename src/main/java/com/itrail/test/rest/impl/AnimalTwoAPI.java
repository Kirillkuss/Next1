
package com.itrail.test.rest.impl;

import com.itrail.test.domain.BaseResponse;
import com.itrail.test.rest.AnimalResourceTwo;
import com.itrail.test.service.AnimalServiceTwo;
import javax.ejb.EJB;
import javax.ws.rs.Path;
/**
 *
 * @author barysevich_k
 */

@Path("animalEM")

public class AnimalTwoAPI implements AnimalResourceTwo{
    
    @EJB private AnimalServiceTwo service;

    @Override
    public BaseResponse getAnimalByList() {
        BaseResponse bs = new BaseResponse(200, "success");
        bs.setData(service.getAnimalByList());
        return bs;
        
    }

    @Override
    public BaseResponse getAnimalById(Integer idAnimal) {
        BaseResponse bs = new BaseResponse(200, "success");
        bs.setData(service.getAnimalById(idAnimal));
        return bs;
    }

    @Override
    public BaseResponse getWithoutOwner() {
        BaseResponse bs = new BaseResponse(200, "success");
        bs.setData(service.withoutOwner());
        System.out.println("WithoutOWNER>>> " + service.withoutOwner());
        return bs;
    }
    
    
    
    
    
}
