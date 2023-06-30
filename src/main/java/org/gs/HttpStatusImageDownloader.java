package org.gs;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class HttpStatusImageDownloader {
    private static final String IMAGES_FOLDER = "./";
    private static final String EXTENSION = ".jpg";

    public void downloadStatusImage(int code) {
        String statusCodeImage = new HttpStatusChecker().getStatusImage(code);
        try(InputStream input = new URL(statusCodeImage).openStream()) {
            String filePath = IMAGES_FOLDER + code + EXTENSION;
            Files.copy(input, Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}