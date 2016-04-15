package com.belhopat.backoffice.session;

import org.springframework.security.core.context.SecurityContextHolder;

import com.belhopat.backoffice.model.User;

public class SessionManager {

    public static User getCurrentUser() {
        if ( SecurityContextHolder.getContext().getAuthentication() != null ) {
            SessionUser userDetails =
                ( SessionUser ) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
            return new User( userDetails.getUserId(),
               userDetails.getUsername(), userDetails.getPassword(),userDetails.getEmail());
        }
        return null;
    }

    public static SessionUser getCurrentUserDetails() {
        SessionUser userDetails = null;
        if ( SecurityContextHolder.getContext().getAuthentication() != null ) {
            userDetails =
                ( SessionUser ) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
        }
        return userDetails;

    }

    public static User getCurrentUserAsEntity() {
        SessionUser userDetails =
            ( SessionUser ) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new User( userDetails.getUserId(), 
            userDetails.getUsername(),
            userDetails.getPassword(),
            userDetails.getEmail() );
    }

}