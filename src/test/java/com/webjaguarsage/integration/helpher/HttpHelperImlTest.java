package com.webjaguarsage.integration.helpher;

import com.webjaguarsage.integration.entity.*;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by soujanya
 */
public class HttpHelperImlTest {

    private HttpHelper httpHelper;
    private AccountAuthorizationConfig authorizationConfig;
    private HttpClient client;
    private final String clientId ="3MVG98_Psg5cppyZ7D3jOCSXgVgkWHq81OIuw6RnGVFuWxgsCqmmybWShacP8Z_q12iG9X8NNjLwl_DhrAWo9";
    private final String secretKey = "857873956965841785";
    private final String username = "souji@sagelive.advancedemedia.dev";
    private final String passwrod = "aem12345";

    @Before
    public void setup(){
        client = HttpClientBuilder.create().build();
        authorizationConfig = new AccountAuthorizationConfig();
        authorizationConfig.setClientId(clientId);
        authorizationConfig.setClientSecretKey(secretKey);
        authorizationConfig.setUserName(username);
        authorizationConfig.setPassword(passwrod);
        authorizationConfig.setGrantType("password");
        httpHelper = new HttpHelperIml(client,authorizationConfig);
    }

    @Test
    public void testGetAuthorizationToken() throws Exception {
        httpHelper.getAuthorizationToken();
    }

    @Test
    public void testPostJournal() throws IOException, WebjaguarSageException {
        httpHelper.getAuthorizationToken();
        httpHelper.postJournal(getTestProductJSONPost(),"product");
    }

    public ProductJSONPost getTestProductJSONPost() {
        ProductJSONPost product = new ProductJSONPost();
        JournalObject ref = new JournalObject();
        ref.setName("ProductFROMPM0030");
        ref.setUid("ProductFROMPM0030");
        product.setReference(ref);
        product.setMessages(new ArrayList<String>());
        product.setFieldValueMap(new HashMap<String, String>());
        product.setFieldsValueMap(new HashMap<String, String>());
        List<Tag> tagList = new ArrayList<Tag>();
        Tag tag = new Tag();
        tag.setAccount(new JournalObject());
        tag.setCompany(new JournalObject());
        tag.setActive(true);
        ref = new JournalObject();
        ref.setName("Product");
        tag.setDimension(ref);
        tag.setForeignCredit(0.0);
        tag.setForeignDebit(0.0);
        tag.setIsPublic(true);
        tag.setLedgerAccount(new JournalObject());
        tag.setProduct(new JournalObject());
        ref = new JournalObject();
        ref.setName("Product Tag PM 0030");
        ref.setUid("ProductTagPM0030");
        tag.setReference(ref);
        tag.setTagCurrency(new JournalObject());
        tag.setUnit(new JournalObject());
        tag.setUnitCredit(0.0);
        tag.setUnitDebit(0.0);
        tag.setUnitValue(50.0);
        tag.setBaseCredit(0.0);
        tag.setBaseCreditLimit(0.0);
        tag.setBaseDebit(0.0);
        tag.setMessages(new ArrayList<String>());
        tag.setFieldsValueMap(new HashMap<String, String>());
        tag.setFieldValueMap(new HashMap<String, String>());
        tagList.add(tag);
        product.setTags(tagList);
        return product;
    }
}