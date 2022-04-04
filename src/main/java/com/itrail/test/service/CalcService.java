
package com.itrail.test.service;

import com.itrail.test.domain.BaseResponce;

import com.itrai.test.exception.ItException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author barysevich_k
 */
@Stateless
public class CalcService {
    @EJB private AnimalService service;
    
  
    public BaseResponce getMyCalc() throws ItException {
           int number = service.getNumber();
           System.out.println("number = " + number);
        switch( number ) {
            case 0 : throw new ItException(100, " TestIllegalAccessException ");
            case 2 : throw new ItException(101, " TestIllegalArgumentException ");
            case 3 : throw new ItException(102, " TestException ");
            case 4 : throw new ItException(103, " TestException 2 ");
            case 5 : throw new ItException(104, " ItException - My Exception" );
        }  
        return new BaseResponce(0, "Success");     
    }
    
    public BaseResponce getMyAnimal() throws ItException{
        int number = service.getNumber();
        switch ( number ){
            case 0 : throw new ItException(90, "TestAnimalException 1");
            case 1 : throw new ItException(91, "TestAnimalException 2");
        }
        return new BaseResponce (0, "Success");
    }
    
    public BaseResponce getAnimalCoat() throws ItException{
        int number = service.getNumber();
        switch ( number ){
            case 0 : throw new ItException(80, "TestCoatException 1");
            case 1 : throw new ItException(81, "TestCoatException 2");
        }
        return new BaseResponce (0, "Success");
    }
    
    public BaseResponce getWithoutOwner() throws ItException{
        int number = service.getNumber();
        switch( number ){
            case 0: throw new ItException(70, "TestOwnerException 1");
            case 1: throw new ItException(71, "TestOwnerException 2");
        }
        return new BaseResponce (0, "Success");
    }
    
}
