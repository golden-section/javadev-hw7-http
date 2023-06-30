package org.gs;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    private static final String BASIC_URL = "https://http.cat/";
    private static final String EXTENSION = ".jpg";

    public String getStatusImage(int code) {
        String urlString = BASIC_URL + code + EXTENSION;
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            if(connection.getResponseCode() == 404) {
                throw new IllegalArgumentException("There is not image for the HTTP status " + code);
            }
            return urlString;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}