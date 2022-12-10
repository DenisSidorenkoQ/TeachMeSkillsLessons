package com.exmaple.springboot.service;

import com.amazonaws.services.s3.AmazonS3;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final AmazonS3 client;

    public String upload(MultipartFile multipartFile) {
        client.getBucketAcl("imgbucket");
        return "";
    }
}
