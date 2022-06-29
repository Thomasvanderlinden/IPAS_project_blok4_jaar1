package com.example.test400.App.Resources;

import com.example.test400.App.StartupListener;
import com.example.test400.Domein.Favoriet;
import com.example.test400.Domein.Oefening;
import com.example.test400.Domein.Supplement.Supplement;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/oefeningen")
public class OefeningenResource {
    @GET
    @Produces("application/json")
    public List<Oefening> opvragenOefening() {
        return StartupListener.oefeningen;
    }


    @GET
    @Produces("application/json")
    @Path("/supplementen")
    public List<Supplement> laatSupplementenZien() {
        return StartupListener.supplementen;

    }


    @POST
    @Path("favoriet")
    @Produces("application/json")
    @Consumes("application/json")
    public Response ontvangFavorietenLijst(Favoriet favoriet) {

        for (Favoriet f : StartupListener.favorietenLijst) {
            if (f.naam.equals(favoriet.naam)) {
                return Response.status(404).entity("already").build();
            }
        }
        StartupListener.favorietenLijst.add(favoriet);
        return Response.ok().build();
    }
    //todo: delete maken, verwijderen uit favorietenlijst:


    @GET
    @Path("favoriet")
    @Produces("application/json")
    public List<Favoriet> returnFavorietenLijst() {
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