package org.example;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public  class Main  {

    public static void main(String[] args) {
        ArrayList <String> list = new ArrayList<>();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get =  new HttpGet("https://jsonplaceholder.typicode.com/users");
        try {
            HttpResponse response = httpClient.execute(get);
            Scanner sc = new Scanner(response.getEntity().getContent());
            System.out.println(response.getStatusLine());
            String a = "";
            while (sc.hasNext()) {
                 a +=" " + sc.next();
            }
            parse(a);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static String parse (String a)throws JSONException{
        JSONArray array = new JSONArray(a);
        for (int i = 0; i< array.length(); i++){
            JSONObject object = array.getJSONObject(i);
            String name = object.getString("name");
            String username = object.getString("username");
            String email = object.getString("email");
            int id = object.getInt("id");
            System.out.println("Client : " + name + ", username for this client is "
                    + username + ", email : "+email + ", ID : "+id );

        }
        return null;

    }

}