package com.example.test400.App.Resources;

import com.azure.core.annotation.Get;
import com.azure.core.annotation.Put;
import com.example.test400.App.StartupListener;
import com.example.test400.Domein.FavorietenLijst;
import com.example.test400.Domein.Oefening;
import com.example.test400.Domein.Supplement.Supplement;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/oefeningen")
public class OefeningenResource {
    @GET
    @Produces("application/json")
    public List<Oefening> opvragenOefening(){
        return StartupListener.oefeningen;
    }


    @GET
    @Produces("application/json")
    @Path("/supplementen")
    public List <Supplement> laatSupplementenZien(){
        return StartupListener.supplementen;

    }


    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response ontvangFavorietenLijst(FavorietenLijst lijst){
        StartupListener.favorietenLijst.add(lijst);
        return Response.ok(StartupListener.favorietenLijst).build();
    }

    @GET
    @Path("/borst")
    @Produces("application/json")
    public List <Oefening> vraagBorst(){
        return StartupListener.borstLijst;
    }


    @GET
    @Path("/rug")
    @Produces("application/json")
    public List <Oefening> vraagRug(){
        return StartupListener.rugLijst;
    }

    @GET
    @Path("/bicep")
    @Produces("application/json")
    public List <Oefening> vraagBicep(){
        return StartupListener.bicepLijst;
    }

    @GET
    @Path("/tricep")
    @Produces("application/json")
    public List <Oefening> vraagTricep(){
        return StartupListener.tricepLijst;
    }


}