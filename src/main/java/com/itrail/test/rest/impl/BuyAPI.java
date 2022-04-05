
package com.itrail.test.rest.impl;

import com.itrai.test.exception.ItException;
import com.itrail.test.domain.BaseResponce;
import com.itrail.test.domain.OrderRq;
import com.itrail.test.domain.OrderRs;
import com.itrail.test.rest.BuyResource;
import com.itrail.test.service.BuyService;
import javax.ejb.EJB;
import javax.ws.rs.Path;
/**
 *
 * @author barysevich_k
 */
@Path("em")
public class BuyAPI implements BuyResource {
        @EJB private BuyService ser;
        //@EJB private DateAndTimeService dt;

    @Override
    public BaseResponce getListOrder() {
        BaseResponce bs = new BaseResponce(200, "success");
        bs.setData(ser.getOrders());
        return bs;
    }

    @Override
    public BaseResponce getOrder(Integer idAnimal, Integer idUser) throws ItException {
        BaseResponce bs = new BaseResponce(200, "success");
        ser.getBuyAnimal(idAnimal, idUser);
        bs.setData("IDAnimal = " + idAnimal +  " IDUser = " + idUser + " TimeOrder: " );
        return bs;
    }

    @Override
    public OrderRs getOrder(OrderRq req) throws ItException {
        BaseResponce<OrderRs> bs = ser.getOrders(req);
        return bs.getData();
    }
}
