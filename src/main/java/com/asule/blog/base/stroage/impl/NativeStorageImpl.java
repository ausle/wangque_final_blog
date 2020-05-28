package com.asule.blog.base.stroage.impl;

import com.asule.utils.FileKit;
import org.springframework.stereotype.Component;

@Component
public class NativeStorageImpl extends AbstractStorage {

    @Override
    public void deleteFile(String storePath) {

    }

    @Override
    public String writeToStore(byte[] bytes, String pathAndFileName) throws Exception {
        String dest = getStoragePath() + pathAndFileName;
        FileKit.writeByteArrayToFile(bytes, dest);
        return pathAndFileName;
    }

    private String getStoragePath() {
        return options.getLocation();
    }
}
