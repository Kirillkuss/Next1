
package com.itrail.test.rest.impl;

import com.itrai.test.exception.ItException;
import com.itrail.test.domain.BaseResponce;
import com.itrail.test.domain.OrderRq;
import com.itrail.test.domain.OrderRs;
import com.itrail.test.rest.BuyResource;
import com.itrail.test.service.BuyService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.ejb.EJB;
import javax.ws.rs.Path;
/**
 *
 * @author barysevich_k
 */
@Path("em")
public class BuyAPI implements BuyResource {
        @EJB private BuyService ser;

    @Override
    public BaseResponce getListOrder() {
        BaseResponce bs = new BaseResponce(200, "success");
        bs.setData(ser.getAllOrders());
        return bs;
    }

    @Override
    public BaseResponce getBuyAnimal(Integer idAnimal, Integer idUser) throws ItException {
        BaseResponce bs = new BaseResponce(200, "success");
        ser.getBuyAnimal(idAnimal, idUser);
        bs.setData("IDAnimal = " + idAnimal +  " IDUser = " + idUser + " TimeOrder: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
        return bs;
    }
    
    @Override
    public OrderRs getOrder(OrderRq req) throws ItException {
        BaseResponce<OrderRs> bs = ser.getOrders(req);
        return bs.getData();
    }
}