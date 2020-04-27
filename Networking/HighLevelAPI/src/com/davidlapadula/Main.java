package com.davidlapadula;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) {
        try {
            URI baseURI = new URI("http://username:password@myserver.com:5000");
            URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
            URI resolvedURI = baseURI.resolve(uri); 

            System.out.println(uri.getScheme());
            System.out.println(uri.getSchemeSpecificPart());
            System.out.println(uri.getAuthority());
            System.out.println(uri.getUserInfo());
            System.out.println(uri.getHost());
            System.out.println(uri.getPort());
            System.out.println(uri.getPath());
            System.out.println(uri.getQuery());
            System.out.println(uri.getFragment());

            URL url = uri.toURL();
            System.out.println(url);

        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
