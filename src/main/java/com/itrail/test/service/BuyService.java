
package com.itrail.test.service;




import com.itrail.test.domain.Animal;
import com.itrail.test.domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author barysevich_k
 */
@Stateless
public class BuyService {
   
    @PersistenceContext
    private EntityManager em;
    
    public void getUserAnimal(Integer idAnimal, Integer idUser){
        Animal ani = em.find(Animal.class, idAnimal);
        User us = em.find(User.class, idUser);
        
//        ani.setOwner(us);
//        em.merge(ani);
        
        us.setWallet(us.getWallet().subtract(ani.getCoat())) ;

        List<Animal> animal =  us.getAnimal();
        animal.add(ani);
        us.setAnimal(animal);
                
        System.out.println(us);
       
        em.merge(us);


        
        
    }
    
    
}

