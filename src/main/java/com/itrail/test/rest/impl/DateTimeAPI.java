
package com.itrail.test.rest.impl;

import com.itrail.test.domain.ServerTime;
import com.itrail.test.rest.DateTimeResource;
import com.itrail.test.service.DateAndTimeService;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author barysevich_k
 */
@Path("dt")
@Consumes({"application/json","application/xml"})
@Produces({"application/json"})
public class DateTimeAPI implements DateTimeResource {
    
    @EJB private DateAndTimeService service1;
    
  @Override 
    public ServerTime dateServiceList() {
        System.out.println("DateAndTimeService>>> " + service1.dateService());
        return new ServerTime();
    }


    

  
}
