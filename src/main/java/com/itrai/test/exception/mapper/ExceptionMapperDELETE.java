
package com.itrai.test.exception.mapper;

import com.itrail.test.domain.BaseResponce;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author barysevich_k
 */
@Provider
public class ExceptionMapperDELETE implements ExceptionMapper<IllegalArgumentException>{

    @Override
    public Response toResponse(IllegalArgumentException e) {
        BaseResponce bs = new BaseResponce();
        bs.setCode(600);
        bs.setMessage(null == e.getMessage() ? "System malfunction" : e.getMessage());
        return Response.ok().entity(bs).build();
    }
    
}
