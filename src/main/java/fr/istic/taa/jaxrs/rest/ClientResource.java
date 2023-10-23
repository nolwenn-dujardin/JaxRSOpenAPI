package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.DaoClient;
import fr.istic.taa.jaxrs.domain.Client;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("client")
@Produces({"application/json", "application/xml"})
public class ClientResource {

    private final DaoClient daoClient = new DaoClient();

    @GET
    @Path("/{clientId}")
    @Operation(summary = "Find client by ID",
            tags = {"clients"},
            description = "Returns a client when 0 < ID <= 10.  ID > 10 or nonintegers will simulate API error conditions",
            responses = {
                    @ApiResponse(description = "The client", content = @Content(
                            schema = @Schema(implementation = Client.class)
                    )),
                    @ApiResponse(responseCode = "404", description = "Pet not found")
            })
    public Response getClientById(
            @Parameter(
            description = "ID of the client that needs to be fetched",
            schema = @Schema(
                    type = "integer",
                    format = "int64",
                    description = "param ID of client that needs to be fetched"
            ),
            required = true)
            @PathParam("clientId") Long clientId) {
        Client c = daoClient.findOne(clientId);
        if (c != null) {
            return Response.ok().entity(c).build();
        } else {
            throw new NotFoundException("Client not found.");
        }
    }

    @POST
    @Consumes("application/json")
    @Operation(summary = "Add a new client to the database",
            tags = {"clients"},
            responses = {
                    @ApiResponse(responseCode = "405", description = "Invalid input")
            })
    public Response addClient(@Parameter(description = "Client that need to be added", required = true) Client client) {

        daoClient.save(client);

        return Response.ok().entity(client).build();
    }

    @PUT
    @Path("/{clientId}")
    @Consumes("application/json")
    @Operation(summary = "Updating a client already in the database",
            tags = {"clients"},
            responses = {
                    @ApiResponse(responseCode = "405", description = "Invalid input")
            })
    public Response updateClient(@PathParam("clientId") Long clientId,
                                 @Parameter(description = "The pet that need to be updated", required = true)
                                 Client client){
        Client existingClient = daoClient.findOne(clientId);

        if (existingClient == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        existingClient.setName(client.getName());
        existingClient.setEmail(client.getEmail());
        existingClient.setMdp(client.getMdp());

        daoClient.update(existingClient);

        return Response.ok().entity(existingClient).build();
    }

    @DELETE
    @Path("/{clientId}")
    @Operation(summary = "Delete an existing client",
            tags = {"clients"},
            responses = {
                    @ApiResponse(responseCode = "405", description = "Invalid input")
            })
    public Response deleteClientById(@PathParam("clientId") Long clientId) {
        daoClient.deleteById(clientId);

        return Response.ok().build();
    }
}
