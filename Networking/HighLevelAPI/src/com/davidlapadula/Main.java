package com.davidlapadula;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
//            URI baseURI = new URI("http://username:password@myserver.com:5000");
//            URI uri = new URI("/catalogue/phones?os=android#samsung");
//            URI uri2 = new URI("/catalogue/tvs?,manufacturer=samsung");
//            URI uri3 = new URI("/catalogue/stores/locations?zip=12345");
//
//            URI resolvedURI = baseURI.resolve(uri);
//            URI resolvedURI2 = baseURI.resolve(uri2);
//            URI resolvedURI3 = baseURI.resolve(uri3);
//
//            System.out.println(uri.getScheme());
//            System.out.println(uri.getSchemeSpecificPart());
//            System.out.println(uri.getAuthority());
//            System.out.println(uri.getUserInfo());
//            System.out.println(uri.getHost());
//            System.out.println(uri.getPort());
//            System.out.println(uri.getPath());
//            System.out.println(uri.getQuery());
//            System.out.println(uri.getFragment());
//
//            URL url = resolvedURI.toURL();
//            URL url2 = resolvedURI2.toURL();
//            URL url3 = resolvedURI3.toURL();
//            System.out.println(url);
//            System.out.println(url2);
//            System.out.println(url3);
//
//            URI relativized = baseURI.relativize(resolvedURI2);
//            System.out.println(relativized);

            URL url = new URL("http://example.com/");
            URLConnection  urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            BufferedReader inputStream = new BufferedReader(
               new InputStreamReader(urlConnection.getInputStream())
            );

            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry: headerFields.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                for (String string: value) {
                    System.out.println("Value " + value);
                }
            }

//            String line = "";
//            while (line != null) {
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
