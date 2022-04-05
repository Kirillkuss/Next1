
package com.itrail.test.service;

import com.itrai.test.exception.ItException;
import com.itrail.test.domain.Animal;
import com.itrail.test.domain.BaseResponce;
import com.itrail.test.domain.Order;
import com.itrail.test.domain.OrderRq;
import com.itrail.test.domain.OrderRs;
import com.itrail.test.domain.User;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
/**
 *
 * @author barysevich_k
 */
@Stateless
public class BuyService {
    @PersistenceContext
    private EntityManager em;
    
    public List <Order> getOrders(){
      LocalDate localDate = LocalDate.now();
      return  em.createQuery("SELECT e FROM Order e WHERE e.time BETWEEN :daystart AND :dayend")
                .setParameter("daystart",localDate.atStartOfDay())
                .setParameter("dayend", LocalDateTime.now())
                .getResultList();
    }
    
    public BaseResponce<OrderRs> getOrders( OrderRq rq){
        return null;
    }
    
    
      public void createOrder(Order...or){
          createOrder(Arrays.asList(or));
      }
      
      @Transactional
      public void createOrder(List<Order> or){
          or.stream().forEach(s->em.merge(s));
      }
      
      public void createOrder(Order or){
          em.merge(or);
      }
      
    
    public void getBuyAnimal(Integer idAnimal, Integer idUser) throws ItException{ 
        
        Animal ani = em.find(Animal.class, idAnimal);
        User us = em.find(User.class, idUser);
        Integer a = ani.getCoat().compareTo(us.getWallet());
     
        if (a > -1) throw new ItException(50," Not enough money to buy an animal ");    
        if( ani.getCount() <= 0) throw new ItException(51,"No animals in the store");
        
        ani.setCount(ani.getCount()-1);
        us.setWallet(us.getWallet().subtract(ani.getCoat())) ;
        List<Animal> animal =  us.getAnimal();
        animal.add(ani);
        us.setAnimal(animal);
        
        List<Order> orders = new LinkedList<>(Arrays.asList(new Order(null,us.getIdUser(),ani.getIdAnimal(),ani.getCoat(), LocalDateTime.now())));
        orders.stream().forEach(s->em.merge(s));
        em.merge(us);   
    }
}

