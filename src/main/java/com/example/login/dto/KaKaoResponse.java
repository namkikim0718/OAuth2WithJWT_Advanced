package com.example.login.dto;

import java.util.Map;

public class KaKaoResponse implements OAuth2Response{

    private final Map<String, Object> attribute;
    private final Map<String, Object> attributeAccount;
    private final Map<String, Object> attributeProfile;

    public KaKaoResponse(Map<String, Object> attribute) {
        this.attribute = attribute;
        this.attributeAccount = (Map<String, Object>) attribute.get("kakao_account");
        this.attributeProfile = (Map<String, Object>) attributeAccount.get("profile");
    }

    @Override
    public String getProvider() {
        return "kakao";
    }

    @Override
    public String getProviderId() {
        return attribute.get("id").toString();
    }

    @Override
    public String getName() {
        return attributeProfile.get("nickname").toString();
    }
}
