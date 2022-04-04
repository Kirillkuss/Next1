
package com.itrail.test.rest.impl;



import com.itrai.test.exception.ItException;
import com.itrail.test.domain.Animal;
import com.itrail.test.domain.BaseResponce;

import com.itrail.test.rest.AnimalResource;
import com.itrail.test.service.AnimalService;
import com.itrail.test.service.CalcService;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author barysevich_k
 */
@Path("animal")
@Consumes({"application/json"})
@Produces({"application/json"})
public class AnimalAPI implements AnimalResource{
    
    @EJB private AnimalService service2;
    @EJB private CalcService service;
   
    @Override
    public BaseResponce getAnimal() throws ItException { 
        BaseResponce bs = new BaseResponce(200,"success");
        //try{
                List<Animal> res = service2.getAnimal();
                bs.setData(res);
                service.getMyAnimal();
//        } catch(ItException ex){
//                return new BaseResponce( ex.getPri(), ex.getMessage() );
//        }
        return bs;
    }

    @Override
    public BaseResponce getAnimalID(Integer idAnimal) throws ItException {
        BaseResponce bs = new BaseResponce(200, "success");
            bs.setData(service2.getAnimalId(idAnimal));
       return bs;
        
    }
    @Override
    public BaseResponce sumCoatAni() throws ItException{ 
        BaseResponce bs = new BaseResponce(200,"success");
            BigDecimal res = service2.sumCoat();   
            bs.setData(res);
            service.getAnimalCoat();
        return bs;
    } 

    @Override
    public BaseResponce withoutOwnerList() throws ItException{
        BaseResponce bs = new BaseResponce(200, "success");
            List<Animal> res = service2.withoutOwner();
            bs.setData(res);
            service.getWithoutOwner();
        return bs;
    }
    
    @Override
     public BaseResponce getMyCalc() throws ItException{
         BaseResponce bs = new BaseResponce(200, "success");
             int rez = service2.getNumber();
             bs.setData(rez);
             service.getMyCalc();
         return bs;
     }
     
    @Override
    public BaseResponce modifyNumber(int number) {
        BaseResponce bs = new BaseResponce(200,"success");
        try{   
            int rez = service2.modifyNumber(number);
            bs.setData(rez);
        } catch (Exception ex){
            return new BaseResponce(400,"not found");
        }
       return bs;
    }

 
    
}
     
     
     
     
     
    
