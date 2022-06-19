package com.example.test400.app;

import com.example.test400.Domein.Oefening;
import com.example.test400.Domein.supplement.Supplement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

import static com.example.test400.app.StartupListener.supplementen;
@Path("/homepage")
public class HelloResource {
    @GET
    @Produces("application/json")
    public List<Oefening> laatOefeningenZien(){
        return StartupListener.oefeningen;
    }


    @GET
    @Produces("application/json")
    @Path("/supplementen")
    public List <Supplement> laatSupplementenZien(){
        return StartupListener.supplementen;
    }
}