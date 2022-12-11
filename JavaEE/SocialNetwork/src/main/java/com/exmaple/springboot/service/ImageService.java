package com.exmaple.springboot.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.exmaple.springboot.model.Image;
import com.exmaple.springboot.repository.ImageRepository;
import com.exmaple.springboot.repository.ProfileRepository;
import com.exmaple.springboot.session.AuthorizedUser;
import lombok.RequiredArgsConstructor;
import org.apache.http.entity.ContentType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final AmazonS3 client;
    private final Bucket imgBucket;
    private final ProfileRepository profileRepository;
    private final ImageRepository imageRepository;
    private static final String PLACEHOLDER_NAME="Placeholder.png";


    public void upload(InputStream stream, String fileName) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        PutObjectRequest request = new PutObjectRequest("imgbucket", fileName, stream, objectMetadata);
        client.putObject(request);
    }

    public void setPlaceholder(int UserId) {
        int imageId = imageRepository.createNewImage(PLACEHOLDER_NAME);
        profileRepository.setNewImage(UserId, imageId);
    }

    public URI getImagePath(String imageName) throws IOException {
        GetObjectRequest request = new GetObjectRequest("imgbucket", imageName);
        S3Object object = client.getObject(request);
        return client.getObject(request).getObjectContent().getHttpRequest().getURI();
    }

    public String getImageByUserId(int userId) {
        return imageRepository.getImageByUserId(userId);
    }

    public int createNewImage(String imageName) {
        return imageRepository.createNewImage(imageName);
    }
}
