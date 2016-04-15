package com.belhopat.backoffice.session;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class SessionUser extends User {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public SessionUser( String username, String password,
        Collection< ? extends GrantedAuthority > authorities ) {
        super( username, password, authorities );
    }

    public SessionUser( Long userId, String accountId, Long instanceId, String instanceCode,
        String role,
        String username,
        String password,
        Collection< ? extends GrantedAuthority > authorities, boolean tcAccept ) {
        super( username, password, authorities );
        this.userId = userId;
    }

    private Long userId;
    private String email;

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getTcAccept() {
        return true;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId( Long userId ) {
        this.userId = userId;
    }


}