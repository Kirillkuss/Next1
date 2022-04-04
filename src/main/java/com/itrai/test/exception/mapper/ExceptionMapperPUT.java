
package com.itrai.test.exception.mapper;

import com.itrail.test.domain.BaseResponce;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author barysevich_k
 */
@Provider
public class ExceptionMapperPUT implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {
 
        BaseResponce bs = new BaseResponce();
        bs.setCode(602);
        bs.setMessage(null == e.getMessage() ? "System malfunction" : e.getMessage());
        return Response.ok().entity(bs).build();
    }
    
    
    
}
