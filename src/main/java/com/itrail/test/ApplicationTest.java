
package com.itrail.test;
import com.itrail.test.domain.Animal;
import com.itrail.test.domain.User;
import com.itrail.test.service.AnimalServiceTwo;
import com.itrail.test.service.UserServiceTwo;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;



/**
 *
 * @author barysevich_k
 */
@Singleton
@Startup
public class ApplicationTest  {
    @EJB private UserServiceTwo service;
    @EJB private AnimalServiceTwo service2;

    @PostConstruct
    public void init(){
        service.createUsers(
                new User(10,"Petr","ppp@mail.ru","+3752508878",new BigDecimal("1000.23")),
                new User(11, "Robert", "rrrrr@ty.ru", "+37529894545", new BigDecimal("1500.34")),
                new User(12, "Misha", "mmmm@ven.by", "+3751224892", new BigDecimal("2000.45") ),
                new User(13,"Andrei","aaaaa@list.com", "+37533783434",new BigDecimal("900.54")));
        
        service2.createAnimal(new Animal(1,"cat",new BigDecimal("100.23"),null),
                              new Animal(5,"dog",new BigDecimal("50.21"), null),
                              new Animal(20,"bird",new BigDecimal("150.25677")),
                              new Animal(24,"turtle",new BigDecimal("200.4686")),
                              new Animal(40,"snake",new BigDecimal("300.8789")));

    }
    

    
    @PreDestroy
    public void destroy(){
        
    }
       
}
