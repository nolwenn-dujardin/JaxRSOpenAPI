package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.DaoUser;
import fr.istic.taa.jaxrs.domain.Pet;
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
    public Response addUser(@Parameter(description = "User object", required = true) User user){

        daoUser.save(user);

        return Response.ok().entity(user).build();
    }
}
