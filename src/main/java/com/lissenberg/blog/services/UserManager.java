package com.lissenberg.blog.services;


import com.lissenberg.blog.domain.User;
import com.lissenberg.blog.domain.UserRole;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Harro Lissenberg
 */
@Named
@SessionScoped
public class UserManager implements Serializable {

    private static final User anonymousUser = new User(-999L, "anonymous", "Anonymous visitor", UserRole.READER);

    private User user;

    @Produces
    @Named
    public User signedInUser() {
        if (user == null) {
            return anonymousUser;
        } else {
            return user;
        }
    }

    public void logon(String username, String password) {
        user = new User(12L, username, username, UserRole.WRITER);
    }

}
