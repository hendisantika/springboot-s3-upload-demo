package com.hendisantika.springboots3uploaddemo.service;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-s3-upload-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/03/20
 * Time: 06.23
 */
@Component
public class S3BucketManager {

    @Autowired
    private AmazonS3 amazonS3Client;

    @Value("${aws.services.bucket}")
    private String bucketName;

}
