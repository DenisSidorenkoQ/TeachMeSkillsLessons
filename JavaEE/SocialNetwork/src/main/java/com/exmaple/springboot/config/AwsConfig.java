package com.exmaple.springboot.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class AwsConfig {
    @Value("${aws.s3.endpoint}")
    private String endpointUrl;
    @Value("${aws.region}")
    private String region;

    private AmazonS3 client;
    @Value("${aws.image-placeholder-path}")
    private String placeholderPath;

    @Bean
    AmazonS3 amazonS3() throws IOException {
        BasicAWSCredentials credentials = new BasicAWSCredentials("foo", "bar");

        AwsClientBuilder.EndpointConfiguration config =
                new AwsClientBuilder.EndpointConfiguration(endpointUrl, region);

        AmazonS3ClientBuilder builder = AmazonS3ClientBuilder.standard();
        builder.withEndpointConfiguration(config);
        builder.withPathStyleAccessEnabled(true);
        builder.withCredentials(new AWSStaticCredentialsProvider(credentials));
        client = builder.build();
        return client;
    }

    @Bean
    Bucket imageBucket() {
        Bucket imgBucket = client.createBucket("imgbucket");
        return imgBucket;
    }

    @Bean
    void uploadPlaceholder() throws URISyntaxException {
        File file = new File(placeholderPath);
        if (!client.doesObjectExist("imgbucket", "Placeholder.png")) {
            PutObjectRequest request = new PutObjectRequest("imgbucket", "Placeholder.png", file);
            client.putObject(request);
        }
    }

}
