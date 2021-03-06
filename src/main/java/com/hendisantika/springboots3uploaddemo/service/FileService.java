package com.hendisantika.springboots3uploaddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.OutputStream;

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

    public byte[] getFile(final String id) throws IOException {
        System.out.println("File to be accessed :: " + getLocation(id));
        Resource resource = this.resourceLoader.getResource(getLocation(id));
        return FileCopyUtils.copyToByteArray(resource.getInputStream());
    }

    public void putFile(final String id) throws IOException {
        System.out.println("File to be placed :: " + getLocation(id));
        OutputStream outputStream =
                ((WritableResource) this.resourceLoader.getResource(getLocation(id))).getOutputStream();
        FileCopyUtils.copy(createFile(id), outputStream);
    }

    private byte[] createFile(final String id) {
        String txt = "This file is created for the user," + id;
        return txt.getBytes();
    }

    private String getLocation(final String id) {
        //location/123.csv
        return this.location + "/" + id + EXTENSION;
    }
}
