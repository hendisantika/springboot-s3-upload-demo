package com.hendisantika.springboots3uploaddemo.controller;

import com.hendisantika.springboots3uploaddemo.service.AmazonS3ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-s3-upload-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/03/20
 * Time: 13.22
 */
@RestController
@RequestMapping("/files")
public class FileHandlerController {
    private static final Logger logger = LoggerFactory.getLogger(FileHandlerController.class);

    @Autowired
    private AmazonS3ClientService amazonS3ClientService;

    @PostMapping
    public Map<String, String> uploadFile(@RequestPart(value = "file") MultipartFile file) {
        this.amazonS3ClientService.uploadFileToS3Bucket(file, true);

        Map<String, String> response = new HashMap<>();
        response.put("message", "file [" + file.getOriginalFilename() + "] uploading request submitted successfully.");

        logger.info(
                "file [" + file.getOriginalFilename() + "] uploading request submitted successfully.");
        return response;
    }

    @DeleteMapping
    public Map<String, String> deleteFile(@RequestParam("filename") String fileName) {
        this.amazonS3ClientService.deleteFileFromS3Bucket(fileName);

        Map<String, String> response = new HashMap<>();
        response.put("message", "file [" + fileName + "] removing request submitted successfully.");
        logger.info(
                "file [" + fileName + "] removing request submitted successfully.");

        return response;
    }
}
