package org.example;
import java.net.*;
import java.net.URL;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        URL aURL = new URL("https://stackoverflow.com/questions/1642028/what-is-the-operator-in-c");
        if (aURL.getHost().equals("github.com")){
            gitUrl(aURL);
            System.out.println("UserName: " + gitUrl(aURL)[1].toString() + "    Repository: " + gitUrl(aURL)[2].toString());
        }
        else if (aURL.getHost().equals("stackoverflow.com")) {
            System.out.println("ID: " + stackUrl(aURL)[2].toString());
        }
        else {
            System.out.println("null");
        }
    }

    //Метод для работы с ссылками на Github.com
    public static String[] gitUrl(URL url) {
        String[] data = url.getFile().toString().split("/");
        return (data);
    }

    //Метод для работы с ссылками на StackoverFlow.com
    public static String[] stackUrl(URL url) {
        String[] data = url.getPath().toString().split("/");
        return data;
    }
}
