package com.example.test400.App.Resources;

import com.example.test400.App.StartupListener;
import com.example.test400.Domein.Blog.Mening;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/blog")
public class BlogResource {

    @GET
    @Produces("application/json")
    public ArrayList iets(){
        return StartupListener.blogArtikelen;

    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response verstuurInformatie(Mening mening) {
        StartupListener.blogArtikelen.add(mening);
        return Response.ok(StartupListener.blogArtikelen).build();
    }

}
