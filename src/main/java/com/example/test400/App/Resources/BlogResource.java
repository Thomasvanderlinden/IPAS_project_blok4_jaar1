package com.example.test400.App.Resources;

import com.example.test400.App.StartupListener;
import com.example.test400.Domein.ArtikelVerwijder;
import com.example.test400.Domein.Blog.Blog;
import com.example.test400.Domein.Blog.Mening;
import com.example.test400.Domein.TipVerwijder;
import com.example.test400.Domein.Tips.Tips;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/blog")
public class BlogResource {

    @GET
    @Produces("application/json")
    public Blog alleBlogArtikelen(){
        return Blog.getBlog();

    }

    @POST
    @RolesAllowed("gebruiker")
    @Produces("application/json")
    @Consumes("application/json")
    public Response verstuurInformatie(Mening mening) {
        Blog.getBlog().addMening(mening);
        return Response.ok(Blog.getBlog().getAllMeningen()).build();
    }


    @DELETE
    @RolesAllowed("gebruiker")
    @Produces("application/json")
    public Response verwijderArtikel(ArtikelVerwijder artikel) {
        for (Mening m : Blog.getBlog().getAllMeningen()) {
            if (m.getNaam().equals(artikel.naam)) {
                Blog.getBlog().getAllMeningen().remove(m);
                return Response.ok(Blog.getBlog().getAllMeningen()).build();
            }
        }
        return Response.status(404).entity("not found").build();
    }

}
