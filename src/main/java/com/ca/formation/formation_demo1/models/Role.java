package com.ca.formation.formation_demo1.models;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

    public static final String ADMIN="ADMIN";
    public static final String READ="READ";

    private String authority;

    public Role(String authority) {
        this.authority = authority;
    }

    public Role() {
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
