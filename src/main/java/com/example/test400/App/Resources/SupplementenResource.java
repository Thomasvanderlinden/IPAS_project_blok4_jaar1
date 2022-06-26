package com.example.test400.App.Resources;

import com.azure.core.annotation.Get;
import com.example.test400.App.StartupListener;
import com.example.test400.Domein.Supplement.Supplement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/supplementen")
public class SupplementenResource {


    @GET
    @Produces("application/json")
    public List<Supplement> opvragenSupplementen(){
        return StartupListener.supplementen;
    }
}
