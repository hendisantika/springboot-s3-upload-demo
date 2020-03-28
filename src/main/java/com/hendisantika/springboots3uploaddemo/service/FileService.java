package com.hendisantika.springboots3uploaddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-s3-upload-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/03/20
 * Time: 05.58
 */
@Service
public class FileService {
    private static final String EXTENSION = ".csv";

    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${file.location}")
    private String location;
}
