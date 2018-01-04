package com.thinksys.demo.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

public class Utility {


	 public static void sendNotification(String title,String description,String token) throws ClientProtocolException, IOException{
		  HttpClient client = HttpClientBuilder.create().build();
		  HttpPost post = new HttpPost("https://fcm.googleapis.com/fcm/send");
		  post.setHeader("Content-type", "application/json");
		  post.setHeader("Authorization", "key=AIzaSyC5GNmBNZ99iuoiGQ9kWVbIgrAs6970RVk");

		  
		  JSONObject message = new JSONObject();
		  message.put("to", token);

		  JSONObject notification = new JSONObject();
		  notification.put("title", title);
		  notification.put("body", description);
		  notification.put("icon", "/firebase-logo.png") ;

		  message.put("notification", notification);
		  post.setEntity(new StringEntity(message.toString(), "UTF-8"));
		  HttpResponse response = client.execute(post);
		  
		  System.out.println(response);
		  System.out.println(message);
		 }
}
