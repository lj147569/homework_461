package com.definesys.dao.impl;

import com.definesys.mpaas.common.adapter.IMpaasSSOAuthentication;
import com.definesys.mpaas.common.adapter.UserProfile;
import com.definesys.mpaas.common.exception.MpaasBusinessException;
import com.definesys.pojo.MdbUser;
import com.definesys.service.MdbUserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class MovieSSOAuth implements IMpaasSSOAuthentication {
    static MdbUser users;
    @Override
    public UserProfile ssoAuth(Map<String, String> header, Map<String, String> cookies) throws MpaasBusinessException {
        UserProfile user = new UserProfile();
        String token = header.get("token");
        if(users==null){
           return UserProfile.anonymous;
        }
        if (!MovieSSOAuth.users.getNickname().equals(token)) {
            throw new MpaasBusinessException("auth failed");
        }
        user.setAnonymous(false);
        user.setToken("jack");
        user.setUserName(users.getPassword());
        return user;
    }

    public static void setUser(MdbUser user) {
        MovieSSOAuth.users = user;
    }
}
