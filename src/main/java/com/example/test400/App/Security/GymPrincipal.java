package com.example.test400.App.Security;

import java.security.Principal;

public class GymPrincipal implements Principal {

    public String name;

    public GymPrincipal(String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }

}
