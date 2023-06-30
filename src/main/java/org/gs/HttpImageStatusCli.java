package org.gs;

import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        String userInput = "";
        try(Scanner scanner = new Scanner(System.in)) {
            while(!userInput.equals("q")) {
                    System.out.println("Please enter the HTTP status code or 'q' to quit:");
                try {
                    userInput = scanner.nextLine();
                    int code = Integer.parseInt(userInput);
                    HttpStatusImageDownloader imageDownloader = new HttpStatusImageDownloader();
                    imageDownloader.downloadStatusImage(code);
                    System.out.println("The image for the status code " + code + " has been downloaded successfully");
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number\n");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
