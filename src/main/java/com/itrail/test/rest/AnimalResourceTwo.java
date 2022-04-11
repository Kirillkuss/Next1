package com.itrail.test.rest;

import com.itrail.test.domain.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author barysevich_k
 */
@Api(value = "Animals", tags = {"Animal"})
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AnimalResourceTwo {

    @GET
    @ApiOperation(value = "Список животных")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " List Animal")
    })
    public BaseResponse getAnimalByList();

    @GET
    @ApiOperation(value = "Поиск животного по ИД")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " One Animal")
    })
    @Path("/{idAnimal}")
    public BaseResponse getAnimalById(@ApiParam(required = true) @PathParam("idAnimal") Integer idAnimal);

    @GET
    @ApiOperation(value = "Животные без хозяина")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " List Animal")
    })
    @Path("/owner/no")
    public BaseResponse getWithoutOwner();

}
