package com.exmaple.springboot.service.storage;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

@Service
@RequiredArgsConstructor
public class AwsStorageService implements StorageService {
    private final AmazonS3 client;
    @Override
    public void uploadFile(InputStream stream, String fileName) {
        PutObjectRequest request = new PutObjectRequest("imgbucket", fileName, stream, new ObjectMetadata());
        client.putObject(request);
    }

    @Override
    public URI getImagePath(String imageName) throws URISyntaxException {
        if (client.doesObjectExist("imgbucket", imageName)) {
            GetObjectRequest request = new GetObjectRequest("imgbucket", imageName);
            return client.getObject(request).getObjectContent().getHttpRequest().getURI();
        }
        return new URI("/static/images/Placeholder.png");
    }

    @Override
    public void deleteImage(String oldImage) {
        DeleteObjectRequest request = new DeleteObjectRequest("imgBucket", oldImage);
        client.deleteObject(request);
    }
}
