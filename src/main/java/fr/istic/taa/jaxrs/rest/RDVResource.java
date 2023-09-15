package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.DaoRDV;
import fr.istic.taa.jaxrs.domain.RDV;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("rdv")
@Produces({"application/json", "application/xml"})
public class RDVResource {

    private final DaoRDV daoRDV = new DaoRDV();

    @GET
    @Path("/{appointmentId}")
    public RDV getClientById(@PathParam("appointmentId") Long appointmentId) {
        return daoRDV.findOne(appointmentId);
    }

    @POST
    @Consumes("application/json")
    public Response addAppointment(@Parameter(description = "RDV object", required = true) RDV appointment) {

        daoRDV.save(appointment);

        return Response.ok().entity(appointment).build();
    }

    @DELETE
    @Path("/{rdvId}")
    public Response deleteClientById(@PathParam("rdvId") Long rdvId) {
        daoRDV.deleteById(rdvId);

        return Response.ok().build();
    }

}
