package com.example.test400.App.Resources;

import com.example.test400.App.StartupListener;
import com.example.test400.Domein.Oefening;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/voeding")
public class VoedingResource {

    @GET
    @Produces("application/json")
    public List opvragenVoeding() {
        return StartupListener.recepten;
    }

}
