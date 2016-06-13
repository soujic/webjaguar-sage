package com.webjaguarsage.integration;

import com.webjaguarsage.integration.config.SageClientConfig;
import com.webjaguarsage.integration.entity.JournalPostTO;
import com.webjaguarsage.integration.entity.WebjaguarSageException;
import com.webjaguarsage.integration.helpher.HttpHelper;
import com.webjaguarsage.integration.helpher.HttpHelperIml;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;

import java.io.IOException;

/**
 * Created by soujanya
 */
public class SageClient {

    private static SageClient sageClient;
    private final HttpHelper httpHelper;
    private final HttpClient httpClient;
    private SageClient(SageClientConfig config) throws WebjaguarSageException {
        Assert.assertNotNull(config);
        Assert.assertNotNull(config.getAccountAuthorizationConfig());
        Assert.assertNotNull(config.getAccountAuthorizationConfig().getClientId());
        Assert.assertNotNull(config.getAccountAuthorizationConfig().getClientSecretKey());
        Assert.assertNotNull(config.getAccountAuthorizationConfig().getGrantType());
        Assert.assertNotNull(config.getAccountAuthorizationConfig().getUserName());
        Assert.assertNotNull(config.getAccountAuthorizationConfig().getPassword());
        httpClient = getHttpClient(config);
        httpHelper = new HttpHelperIml(httpClient,config.getAccountAuthorizationConfig());
        httpHelper.getAuthorizationToken();
    }

    private HttpClient getHttpClient(SageClientConfig config) {
        //TODO better construction of http client based of configuration.
        CloseableHttpClient client = HttpClientBuilder.create().build();
        return client;
    }

    public static SageClient getSageClient(SageClientConfig config) throws WebjaguarSageException {
        if(sageClient != null) return sageClient;
        sageClient = new SageClient(config);
        return sageClient;
    }

    public void postJournal(JournalPostTO journalPostTO) {
        try {
            httpHelper.postJournal(journalPostTO,"journal");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
