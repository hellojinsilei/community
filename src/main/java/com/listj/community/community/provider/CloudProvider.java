package com.listj.community.community.provider;

import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;
import com.baidubce.services.bos.model.PutObjectResponse;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;

@Service
public class CloudProvider {
    String ACCESS_KEY_ID = "7435a3c21027474f95ec2543ccfb7967";
    String SECRET_ACCESS_KEY = "d5e2e299488e42e68910dfb8031c2647";
    String ENDPOINT ="http://listj.bj.bcebos.com";


    public String PutObject(String objectKey, InputStream fileStream){
        BosClientConfiguration config = new BosClientConfiguration();
        config.setCredentials(new DefaultBceCredentials(ACCESS_KEY_ID, SECRET_ACCESS_KEY));
        config.setEndpoint(ENDPOINT);
        BosClient client = new BosClient(config);
        PutObjectResponse putObjectResponseFromInputStream  = client.putObject("listj", objectKey, fileStream);
        return putObjectResponseFromInputStream .getETag();
    }


}
