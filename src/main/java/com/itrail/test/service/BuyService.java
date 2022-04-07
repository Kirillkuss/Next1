
package com.itrail.test.service;

import com.itrai.test.exception.ItException;
import com.itrail.test.domain.Animal;
import com.itrail.test.domain.BaseResponce;
import com.itrail.test.domain.Order;
import com.itrail.test.domain.OrderRq;
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
    
    public List <Order> getAllOrders(){      
      LocalDate localDate = LocalDate.now();
      return  em.createQuery("SELECT e FROM Order e WHERE e.time BETWEEN :daystart AND :dayend")
                .setParameter("daystart",localDate.atStartOfDay())
                .setParameter("dayend", LocalDateTime.now())
                .getResultList();
    }
    
    public BaseResponce<List<Order>> getOrders( OrderRq rq){
        BaseResponce<List<Order>> bs = new BaseResponce<>(200,"success");
        try{
            List<Order> order  = em.createQuery("select o FROM Order o where :uid is null or o.userID = :uid"
                                                + " AND :tiOrder is null or o.time = :tiOrder"
                                                + " AND :oid is null or o.idOrder = :oid")
                                   .setParameter("uid", rq.getIdUser())
                                   .setParameter("tiOrder", rq.getTime())
                                   .setParameter("oid", rq.getIdOrderRq()).getResultList(); 
            System.out.println("ORDER>>>" + order);
            bs.setData( order );
            return bs;
        }catch(Exception ex){
            ex.printStackTrace(System.err);
            bs.setCode(999);
            bs.setMessage(null == ex.getMessage() ?  "System mullfunction " : ex.getMessage());
            return bs;
        }  
    }
    
    public BaseResponce<Order> getOrder( OrderRq rq) throws ItException{
        //return  BaseResponce.success().setData(getOrders(rq));
        BaseResponce r = new BaseResponce<>(0,"success"); 
            BaseResponce<List<Order>> ress = getOrders(rq);
            if(ress.getCode() == 0 && null!= ress.getData() && !((List<Order>)ress.getData()).isEmpty() ){
                r.setData( ((List<Order>)ress.getData()).get(0)  );
            } else {
                r.setCode(ress.getCode());
                r.setMessage(ress.getMessage());
            } 
         return r;
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

