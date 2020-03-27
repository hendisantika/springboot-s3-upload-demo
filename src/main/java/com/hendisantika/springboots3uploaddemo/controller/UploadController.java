package com.hendisantika.springboots3uploaddemo.controller;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-s3-upload-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/03/20
 * Time: 12.53
 */
@RestController
@RequestMapping("/home/")
public class UploadController {

    @Autowired
    private AmazonS3 s3client;

    @Value("${endpointUrl}")
    private String endpointUrl;

    @Value("${bucketName}")
    private String bucketName;

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }


    private String uploadFileTos3bucket(String fileName, File file) {
        try {
            s3client.putObject(new PutObjectRequest(bucketName, fileName, file));
        } catch (AmazonServiceException e) {
            return "uploadFileTos3bucket().Uploading failed :" + e.getMessage();
        }
        return "Uploading Successfull -> ";
    }
}
