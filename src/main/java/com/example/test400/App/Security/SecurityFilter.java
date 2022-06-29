package com.example.test400.App.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;


@Provider
@Priority(Priorities.AUTHENTICATION)
public class SecurityFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println("draai elke keer");


        String authHeader = requestContext.getHeaderString("Authorization");
        if(authHeader == null){
            return;
        }

        authHeader = authHeader.replace("Bearer", "");


        try{
            Jws<Claims> claims = Jwts.parser().setSigningKey(AuthenticationResource.key).parseClaimsJws(authHeader);
            String subject = claims.getBody().getSubject();
            requestContext.setSecurityContext(new GymSecurityContext(new GymPrincipal(subject)));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}

