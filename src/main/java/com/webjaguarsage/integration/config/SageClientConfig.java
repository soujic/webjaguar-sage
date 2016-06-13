package com.webjaguarsage.integration.config;

import com.webjaguarsage.integration.entity.AccountAuthorizationConfig;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by soujanya
 */
@Getter @Setter
public class SageClientConfig {
    private AccountAuthorizationConfig accountAuthorizationConfig;
    private Integer readTimeOut;
    private Integer readOut;
    private Integer maxThreadPool;
}
