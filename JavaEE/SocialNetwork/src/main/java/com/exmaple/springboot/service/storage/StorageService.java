package com.exmaple.springboot.service.storage;

import java.io.InputStream;
import java.net.URI;

public interface StorageService {
    void uploadFile(InputStream stream, String fileName);

    URI getImagePath(String imageName);

    void deleteImage(String oldImage);
}
