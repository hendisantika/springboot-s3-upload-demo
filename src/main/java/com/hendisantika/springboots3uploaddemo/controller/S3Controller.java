package com.hendisantika.springboots3uploaddemo.controller;

import com.hendisantika.springboots3uploaddemo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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
@RequestMapping("demo")
public class S3Controller {
    @Autowired
    private FileService fileService;

    @GetMapping("get/{id}")
    public ResponseEntity<ByteArrayResource> getFile(@PathVariable String id) throws IOException {
        final ByteArrayResource byteArrayResource = new ByteArrayResource(this.fileService.getFile(id));
        return ResponseEntity
                .ok()
                .contentLength(byteArrayResource.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header("Content-Disposition", "attachment; filename=" + id + ".csv")
                .body(byteArrayResource);
    }

    @GetMapping("put/{id}")
    public void putFile(@PathVariable String id) throws IOException {
        this.fileService.putFile(id);
    }
}
