package com.belhopat.backoffice.session;

import com.belhopat.backoffice.model.User;

public class SessionManager {
	
	static User userEntity = null;

	public static void setCurrentUser(User user){
		userEntity=user;
	}
	
    public static User getCurrentUser() {
            return userEntity;
    }


}