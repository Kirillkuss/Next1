
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
public class ExceptionMapperPOST implements ExceptionMapper<NullPointerException> {

    @Override
    public Response toResponse(NullPointerException e) {
        BaseResponce bs = new BaseResponce();
        bs.setCode(601);
        bs.setMessage(null == e.getMessage() ? "no user with this idUser" : e.getMessage());
        return Response.ok().entity(bs).build();
    }
    
    
}