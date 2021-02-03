package com.company.carservices.controller.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CurrentUserUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {
    private int id;
    public CurrentUserUsernamePasswordAuthenticationToken(int id, Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
