package com.example.test400.App.Resources;

import com.azure.core.annotation.Get;
import com.azure.core.annotation.Post;
import com.example.test400.App.StartupListener;
import com.example.test400.App.TipVerwijder;
import com.example.test400.Domein.Tips.Tips;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/tipsTricks")
public class TipsTricksResource {

    @GET
    @Produces("application/json")
    public List vraagTipsOp() {
        return StartupListener.tipsTricks;
    }

    @POST
    @RolesAllowed("gebruiker")
    @Produces("application/json")
    @Consumes("application/json")
    public Response tipsidk(Tips tips) {
        StartupListener.tipsTricks.add(tips);
        return Response.ok(StartupListener.tipsTricks).build();
    }

    @DELETE
    @Path("tip")
    //todo: @RolesAllowed moet nog
    @Produces("application/json")
    public Response verwijderTip(TipVerwijder tip) {
        for (Tips t : StartupListener.tipsTricks) {
            if (t.getTipnaam().equals(tip.tipnaam)) {
                StartupListener.tipsTricks.remove(t);
                return Response.ok(StartupListener.tipsTricks).build();
            }
        }
        return Response.status(404).entity("not found").build();
    }
}
