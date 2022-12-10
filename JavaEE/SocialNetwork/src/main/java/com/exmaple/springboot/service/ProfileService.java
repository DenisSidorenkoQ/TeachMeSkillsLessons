package com.exmaple.springboot.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.exmaple.springboot.model.Profile;
import com.exmaple.springboot.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URI;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final AmazonS3 client;
    private final Bucket imgBucket;

    public Profile getProfile(int userId) {
        return profileRepository.getProfile(userId);
    }
    public URI getImagePath(String imageName) {
        System.out.println(imgBucket);
        GetObjectRequest request = new GetObjectRequest("imgbucket", imageName);
        return client.getObject(request).getObjectContent().getHttpRequest().getURI();
    }
}
