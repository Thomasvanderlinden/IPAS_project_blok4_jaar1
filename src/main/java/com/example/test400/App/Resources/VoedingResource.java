package com.example.test400.App.Resources;

import com.azure.core.annotation.Get;
import com.example.test400.App.StartupListener;
import com.example.test400.Domein.Oefening;
import com.example.test400.Domein.Recept.Recept;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/voeding")
public class VoedingResource {

    @GET
    @Produces("application/json")
    public List opvragenVoeding() {
        return StartupListener.recepten;
    }



    @GET
    @Path("{naam}")
    @Produces("application/json")
    public Response returnRecept(@PathParam("naam") String naam){
        for(Recept r : StartupListener.recepten){
            if(r.getNaam().equals(naam)){
                return Response.ok(r).build();
            }
        }return Response.status(404).entity("not found").build();
    }
}
