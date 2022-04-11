package com.itrail.test.rest;

import com.itrai.test.exception.ItException;
import com.itrail.test.domain.BaseResponse;
import com.itrail.test.domain.Order;
import com.itrail.test.domain.OrderRequest;
import com.itrail.test.domain.OrderResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author barysevich_k
 */
@Api(value = "BuyAnimals", tags = {"Buy"})
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BuyResource {

    @GET
    @ApiOperation(value = "Поиск заказов с 00:00 по настоящее время сегодняшего дня")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Список заказов")
    })
    public BaseResponse getListOrder();

    @POST
    @ApiOperation(value = "Покупка питомца")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Покупка завершена"),
        @ApiResponse(code = 500, message = "Покупка не состоялась", response = BaseResponse.class)
    })
    @Path("/{idAnimal}/{idUser}")
    public BaseResponse getBuyAnimal(@ApiParam(required = true) @PathParam("idAnimal") Integer idAnimal,
                                     @ApiParam(required = true) @PathParam("idUser") Integer idUser) throws ItException;

    @POST
    @ApiOperation(value = "Поиск заказа")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Заказ найден")
    })
    @Path("/order")
    public Order getOrder(@ApiParam(required = true) OrderRequest req) throws ItException;

    @POST
    @ApiOperation(value = "Поиск заказов")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Заказы найдены", response = OrderResponse.class ),
        @ApiResponse(code = 500, message = " Заказ не найден", response = BaseResponse.class )
            
    })
    @Path("/orders")
    public OrderResponse getOrders(@ApiParam(required = true) OrderRequest req) throws ItException;

}
