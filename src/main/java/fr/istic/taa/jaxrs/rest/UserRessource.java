package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.DaoUser;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("user")
@Produces({"application/json", "application/xml"})
public class UserRessource {

    DaoUser daoUser = new DaoUser();
    @GET
    @Path("/{userId}")
    public User getUserById(@PathParam("userId") Long userId)  {
        return daoUser.findOne(userId);
    }

    @POST
    @Consumes("application/json")
    public Response addUser(@Parameter(required = true) User user){

        daoUser.save(user);

        return Response.ok().entity(user).build();
    }

    @PUT
    @Path("/update")
    @Consumes("application/json")
    public Response updateUser(@Parameter(required = true) User user){
        daoUser.update(user);

        return Response.ok().entity(user).build();
    }

    @DELETE
    @Path("{userId}")
    public Response deleteUser(@PathParam("userId") Long userId){
        daoUser.deleteById(userId);

        return Response.ok().build();
    }
}
