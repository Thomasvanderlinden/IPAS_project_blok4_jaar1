package com.example.test400.App.Resources;

import com.example.test400.App.StartupListener;
import com.example.test400.Domein.Blog.Blog;
import com.example.test400.Domein.Blog.Mening;

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
    //@RolesAllowed("gebruiker")
    @Produces("application/json")
    @Consumes("application/json")
    public Response verstuurInformatie(Mening mening) {
        Blog.getBlog().addMening(mening);
        return Response.ok(Blog.getBlog().getAllMeningen()).build();
    }

}
