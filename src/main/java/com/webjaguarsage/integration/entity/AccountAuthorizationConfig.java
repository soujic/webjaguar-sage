package com.webjaguarsage.integration.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by soujanya
 */
@Getter @Setter
public class AccountAuthorizationConfig {
    private String grantType;
    private String clientId;
    private String clientSecretKey;
    private String userName;
    private String password;
}
