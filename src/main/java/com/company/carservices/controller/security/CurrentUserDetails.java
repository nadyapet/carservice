package com.company.carservices.controller.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import static java.util.Collections.emptyList;

public class CurrentUserDetails extends org.springframework.security.core.userdetails.User {
    private int id;

    public CurrentUserDetails() {
        super("", "", emptyList());
    }

    public CurrentUserDetails(int id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);

        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
