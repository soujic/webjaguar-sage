package com.webjaguarsage.integration.helpher;

import com.webjaguarsage.integration.entity.WebjaguarSageException;

import java.io.IOException;

/**
 * Created by soujanya
 */
public interface HttpHelper {
    void postJournal(Object object,String type) throws IOException;
    void getAuthorizationToken() throws WebjaguarSageException;
}
