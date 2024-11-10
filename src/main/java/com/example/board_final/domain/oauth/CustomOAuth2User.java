package com.example.board_final.domain.oauth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

public class CustomOAuth2User implements OAuth2User {
    private OAuth2User oauth2User;
    private String name;
    private String profilePic;
    private String providerId;

    public CustomOAuth2User(OAuth2User oauth2User, String name, String profilePic, String providerId) {
        this.oauth2User = oauth2User;
        this.name = name;
        this.profilePic = profilePic;
        this.providerId = providerId;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oauth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return oauth2User.getAuthorities();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public String getProviderId(){return providerId;}
}
