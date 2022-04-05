package com.itrai.test.exception.mapper;


import com.itrai.test.exception.ItException;
import com.itrail.test.domain.BaseResponce;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author barysevich_k
 */
@Provider
public class ItExceptionMapper implements ExceptionMapper<ItException>{

    @Override
    public Response toResponse(ItException e) {
        BaseResponce bs = new BaseResponce();
        bs.setCode(e.getPri() == 0 ? 999 : e.getPri());
        bs.setMessage(null == e.getMessage() ? "System malfunction" : e.getMessage());
        return Response.status( e.getPri() == 0 ? 200 : e.getPri() ).entity(bs).build();
    }


    
}
