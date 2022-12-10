package com.exmaple.springboot.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class AwsConfig {
    @Value("${aws.s3.endpoint}")
    private String endpointUrl;
    @Value("${aws.region}")
    private String region;

    private AmazonS3 client;

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

}
