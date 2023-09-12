package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.DaoClient;
import fr.istic.taa.jaxrs.dao.generic.DaoUser;
import fr.istic.taa.jaxrs.domain.Client;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("client")
@Produces({"application/json", "application/xml"})
public class ClientResource {

    private DaoClient daoClient = new DaoClient();

    @GET
    @Path("/{clientId}")
    public User getClientById(@PathParam("clientId") Long clientId) {
        return daoClient.findOne(clientId);
    }

    @POST
    @Consumes("application/json")
    public Response addClient(@Parameter(description = "Client object", required = true) Client client) {

        System.err.println("ICI");

        daoClient.save(client);

        return Response.ok().entity(client).build();
    }

    @PUT
    @Path("/update")
    @Consumes("application/json")
    public Response updateClient(@Parameter(required = true) Client client){
        daoClient.update(client);

        return Response.ok().entity(client).build();
    }

    @DELETE
    @Path("/{clientId}")
    public Response deleteClientById(@PathParam("clientId") Long clientId) {
        daoClient.deleteById(clientId);

        return Response.ok().build();
    }
}
