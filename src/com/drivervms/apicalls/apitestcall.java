package com.drivervms.apicalls;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class apitestcall {
	
public static void postreq() throws ClientProtocolException, IOException{
	System.out.println("weell");
	String url = "http://qa-driverapi.goplus.in/shuttl/getAppConfig";
	HttpClient client = new DefaultHttpClient();
	HttpPost request = new HttpPost(url);
	request.addHeader("Content-Type","application/x-www-form-urlencoded");
	HttpResponse response = client.execute(request);
	System.out.println("\nSending request to URL : " + url);
	System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

	BufferedReader rd = new BufferedReader(
                   new InputStreamReader(response.getEntity().getContent()));

	StringBuffer result = new StringBuffer();
	String line = "";
	while ((line = rd.readLine()) != null) {
		result.append(line);
	}
	System.out.println(result.toString());
}
public void buildjson(){
	JSONObject obj = new JSONObject();
	JSONObject obj1=new JSONObject();
			
	obj.put("userName", "me");
	JSONArray list = new JSONArray();
    obj.put("reportTimeDetails", list);
    list.add(obj1);
    obj1.put("id", "1");
	obj1.put("from", "1");
	obj1.put("to", "1");
	obj1.put("reportedTime", "1");
	obj1.put("locationId", "1");
	obj1.put("routeId", "1");
	
	//System.out.println(list);
	System.out.println(obj);
}
//public void postreq2() throws ClientProtocolException, IOException{
//	System.out.println("weell");
//	String url = "http://qa-driverapi.goplus.in/shuttl/getSchedule";
//	HttpClient client = new DefaultHttpClient();
//	HttpPost request = new HttpPost(url);
//	request.addHeader("Content-Type","application/x-www-form-urlencoded");
//	List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
//	urlParameters.add(new BasicNameValuePair("driver_id", "4"));
//	request.setEntity(new UrlEncodedFormEntity(urlParameters));
//	HttpResponse response = client.execute(request);
//	System.out.println("\nSending request to URL : " + url);
//	System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
//
//	BufferedReader rd = new BufferedReader(
//                   new InputStreamReader(response.getEntity().getContent()));
//
//	StringBuffer result = new StringBuffer();
//	String line = "";
//	while ((line = rd.readLine()) != null) {
//		result.append(line);
//	}
//	System.out.println(result.toString());
//}
//public void postreq3() throws IOException{
//	String jsonstring="{"
//            + "'reportTimeDetails:["
//	        + "{'id':'1','from':'343','to':'73','reportedTime':'','locationId':'','routeId':''}"
//	        +"],"
//	        +"'userName':'23'"
//	        + "}";
//	//System.out.println(jsonstring);
//	OkHttpClient client = new OkHttpClient();  
//	//String ApiURL = "http://qa-driverapi.goplus.in/shuttl/getSchedule";
//	String ApiURL = "http://52.77.34.252:8080/shuttl/getSchedule";
//	MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");    
//    RequestBody body = RequestBody.create(mediaType,"routeId=33&driver_id=4&appVersion=22");
//    Request request = new Request.Builder().url(ApiURL).post(body).build();
//    Response response = client.newCall(request).execute();
//    System.out.println(response.body().toString());         
//    //JSONObject JSONResponseBody = new JSONObject(response.body().string());
//}
public static void main(String args[]) throws IOException{
	apitestcall a1=new apitestcall();
	a1.buildjson();
}
}
