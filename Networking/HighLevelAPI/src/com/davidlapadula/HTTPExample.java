package com.davidlapadula;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HTTPExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.flickr.com/services/feeds/photos_public.gne?tags=cats");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");

            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);

            if (responseCode != 200) {
                System.out.println("Error");
                return;
            }

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            String line;
            while ((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }
            inputReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
