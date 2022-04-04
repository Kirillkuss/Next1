
package com.itrail.test.rest;

import com.itrail.test.domain.ServerTime;

import javax.ws.rs.GET;

/**
 *
 * @author barysevich_k
 */
public interface DateTimeResource {
    
    @GET
    public ServerTime dateServiceList();
   
}
