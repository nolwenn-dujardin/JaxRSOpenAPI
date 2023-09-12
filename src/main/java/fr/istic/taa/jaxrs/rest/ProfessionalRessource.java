package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.DaoProfessional;
import fr.istic.taa.jaxrs.domain.Professional;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("pro")
@Produces({"application/json", "application/xml"})
public class ProfessionalRessource {

    DaoProfessional daoProfessional = new DaoProfessional();

    @GET
    @Path("/{proId}")
    public User getProById(@PathParam("proId") Long proId)  {
        return daoProfessional.findOne(proId);
    }

    @POST
    @Consumes("application/json")
    public Response addPro(@Parameter(required = true) Professional pro){
        System.out.println("ok");
        daoProfessional.save(pro);

        return Response.ok().entity(pro).build();
    }
}
