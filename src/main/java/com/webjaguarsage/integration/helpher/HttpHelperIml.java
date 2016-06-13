package com.webjaguarsage.integration.helpher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webjaguarsage.integration.config.Constants;
import com.webjaguarsage.integration.entity.AccountAuthorizationConfig;
import com.webjaguarsage.integration.entity.JournalPostTO;
import com.webjaguarsage.integration.entity.WebjaguarSageException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by soujanya
 */
public class HttpHelperIml implements HttpHelper {

    private HttpClient client;
    private final ObjectMapper mapper = new ObjectMapper();
    private final AccountAuthorizationConfig authorizationConfig;
    private String accessKey;
    private String instanceUrl;

    public HttpHelperIml(HttpClient client,AccountAuthorizationConfig authorizationConfig) {
        this.client = client;
        this.authorizationConfig = authorizationConfig;
    }

    public void postJournal(Object object,String type) throws IOException {
        HttpPost httpPost = new HttpPost(instanceUrl+Constants.API_BASE_URL+Constants.VERSION+type);
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setHeader("Authorization", "Bearer "+accessKey);
        String jsonString = this.mapper.writeValueAsString(object);
        StringEntity stringEntity = new StringEntity("["+jsonString+"]");
        System.out.println(jsonString);
        httpPost.setEntity(stringEntity);
        HttpResponse response = client.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        System.out.println(responseString);
    }

    public void getAuthorizationToken() throws WebjaguarSageException {
        PostMethod post = new PostMethod(Constants.AUTHORIZATION_UL);
        post.addParameter("grant_type", authorizationConfig.getGrantType());
        post.addParameter("client_id", authorizationConfig.getClientId());
        post.addParameter("client_secret", authorizationConfig.getClientSecretKey());
        post.addParameter("username", authorizationConfig.getUserName());
        post.addParameter("password", authorizationConfig.getPassword());
        try {
            new org.apache.commons.httpclient.HttpClient().executeMethod(post);
            JSONObject authResponse = new JSONObject(new JSONTokener(new InputStreamReader(post.getResponseBodyAsStream())));
            accessKey = authResponse.getString("access_token");
            instanceUrl = authResponse.getString("instance_url");
        } catch (Exception e) {
            throw new WebjaguarSageException(Constants.AUTHORIZATION_ERROR_MESSAGE);

        }
        if(accessKey == null || instanceUrl == null) {
            throw new WebjaguarSageException(Constants.AUTHORIZATION_ERROR_MESSAGE);
        }
    }
}
