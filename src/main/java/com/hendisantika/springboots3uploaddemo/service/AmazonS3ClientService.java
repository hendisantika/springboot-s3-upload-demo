package com.hendisantika.springboots3uploaddemo.service;

import com.amazonaws.services.s3.AmazonS3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-s3-upload-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/03/20
 * Time: 13.13
 */
@Service
public class AmazonS3ClientService {
    private static final Logger logger = LoggerFactory.getLogger(AmazonS3ClientService.class);
    private String awsS3AudioBucket;
    private AmazonS3 amazonS3;
}
