package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.DaoUser;
import fr.istic.taa.jaxrs.domain.Client;
import fr.istic.taa.jaxrs.domain.User;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("client")
@Produces({"application/json", "application/xml"})
public class ClientResource {

    private DaoUser daoUser = new DaoUser();

    @GET
    @Path("/{clientId}")
    public User getClientById(@PathParam("clientId") Long clientId) {
        return daoUser.findOne(clientId);
    }


}
