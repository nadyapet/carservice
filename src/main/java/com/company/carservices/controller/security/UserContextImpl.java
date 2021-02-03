package com.company.carservices.controller.security;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserContextImpl implements UserContext {

    @Override
    public int getUserId() {
        int currentUserId = ((CurrentUserUsernamePasswordAuthenticationToken)SecurityContextHolder.getContext().getAuthentication()).getId();
        return currentUserId;
    }
}
