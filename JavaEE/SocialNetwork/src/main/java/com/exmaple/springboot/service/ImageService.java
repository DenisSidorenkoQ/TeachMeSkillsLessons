package com.exmaple.springboot.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.exmaple.springboot.repository.ImageRepository;
import com.exmaple.springboot.repository.ProfileRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final AmazonS3 client;
    private final ProfileRepository profileRepository;
    private final ImageRepository imageRepository;
    private static final String PLACEHOLDER_NAME = "Placeholder.png";


    public void upload(InputStream stream, String fileName) {
        PutObjectRequest request = new PutObjectRequest("imgbucket", fileName, stream, new ObjectMetadata());
        client.putObject(request);
    }

    public void setPlaceholder(int userId) {
        int imageId = imageRepository.createNewImage(PLACEHOLDER_NAME);
        profileRepository.setNewImage(userId, imageId);
    }

    public URI getImagePath(String imageName) throws IOException {
        GetObjectRequest request = new GetObjectRequest("imgbucket", imageName);
        return client.getObject(request).getObjectContent().getHttpRequest().getURI();
    }

    public String getImageByUserId(int userId) {
        return imageRepository.getImageByUserId(userId);
    }

    public int createNewImage(String imageName) {
        return imageRepository.createNewImage(imageName);
    }
}
