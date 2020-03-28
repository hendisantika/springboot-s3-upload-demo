package com.hendisantika.springboots3uploaddemo.controller;

import com.hendisantika.springboots3uploaddemo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-s3-upload-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/03/20
 * Time: 05.57
 */
@RestController
public class S3Controller {
    @Autowired
    private FileService fileService;
}
