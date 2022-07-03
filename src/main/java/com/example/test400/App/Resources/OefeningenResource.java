package com.example.test400.App.Resources;

import com.example.test400.App.StartupListener;
import com.example.test400.Domein.Favoriet;
import com.example.test400.Domein.Oefening;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.time.OffsetDateTime;
import java.util.List;

@Path("/oefeningen")
public class OefeningenResource {
    @GET
    @Produces("application/json")
    public List<Oefening> opvragenOefening() {
        return StartupListener.oefeningen;
    }


    @GET
    @Path("{code}")
    @Produces("application/json")
    public Response iets(@PathParam("code") String oefening) {
        for (Oefening f : StartupListener.oefeningen) {
            if (f.getNaam().equals(oefening)) {
                return Response.ok(f).build();
            }
        }
        return Response.status(404).entity("not found").build();
    }


    @POST
    @Path("favoriet")
    @Produces("application/json")
    @Consumes("application/json")
    public Response ontvangFavorietenLijst(Favoriet favoriet) {

        for (Oefening o : StartupListener.favorietenLijst) {
            if (o.getNaam().equals(favoriet.naam)) {
                return Response.status(404).entity("already").build();
            }
        }
        for (Oefening o : StartupListener.oefeningen) {
            if (o.getNaam().equals(favoriet.naam)) {
                StartupListener.favorietenLijst.add(o);
            }
        }
        return Response.ok(StartupListener.favorietenLijst).build();
    }


    @DELETE
    @Path("favoriet")
    @Produces("application/json")
    public Response verwijderFavorietUitLijst(Favoriet favoriet) {
        for (Oefening o : StartupListener.favorietenLijst) {
            if (o.getNaam().equals(favoriet.naam)) {
                StartupListener.favorietenLijst.remove(o);
                return Response.ok().build();
            }
        }

        return Response.status(404).entity("not found").build();
    }

    @GET
    @Path("favoriet")
    @Produces("application/json")
    public List<Oefening> returnFavorietenLijst() {
        return StartupListener.favorietenLijst;
    }


    @GET
    @Path("/borst")
    @Produces("application/json")
    public List<Oefening> vraagBorst() {
        return StartupListener.borstLijst;
    }


    @GET
    @Path("/rug")
    @Produces("application/json")
    public List<Oefening> vraagRug() {
        return StartupListener.rugLijst;
    }

    @GET
    @Path("/bicep")
    @Produces("application/json")
    public List<Oefening> vraagBicep() {
        return StartupListener.bicepLijst;
    }

    @GET
    @Path("/tricep")
    @Produces("application/json")
    public List<Oefening> vraagTricep() {
        return StartupListener.tricepLijst;
    }


}