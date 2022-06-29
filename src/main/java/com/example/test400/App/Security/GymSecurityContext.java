package com.example.test400.App.Security;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

public class GymSecurityContext  implements SecurityContext {
    public Principal currentPrincipal;

    public GymSecurityContext(Principal currentPrincipal){
        this.currentPrincipal = currentPrincipal;
    }



    @Override
    public Principal getUserPrincipal() {
        return currentPrincipal;
    }

    @Override
    public boolean isUserInRole(String role) {
        if(this.currentPrincipal.getName().equals("admin") && role.equals("admin")){
            return true;
        }else if(this.currentPrincipal.getName().equals("thomas")&& role.equals("gebruiker")){
            return true;
        }
        return false;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public String getAuthenticationScheme() {
        return "JWT";
    }
}


