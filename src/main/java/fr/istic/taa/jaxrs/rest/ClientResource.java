package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.DaoUser;
import fr.istic.taa.jaxrs.domain.Client;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("client")
@Produces({"application/json", "application/xml"})
public class ClientResource {

    private DaoUser daoUser = new DaoUser();

    @GET
    @Path("/{clientId}")
    public User getClientById(@PathParam("clientId") Long clientId) {
        return daoUser.findOne(clientId);
    }

    @POST
    @Consumes("application/json")
    public Response addClient(@Parameter(description = "Client object", required = true) Client client){

        daoUser.save(client);

        return Response.ok().entity(client).build();
    }

}
