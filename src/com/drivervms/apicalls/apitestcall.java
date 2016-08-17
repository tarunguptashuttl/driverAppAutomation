package com.drivervms.apicalls;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class apitestcall {
	public final static String BASE_URL = "http://qa-driverapi.goplus.in/shuttl";
	public final static String App_Config = BASE_URL + "/getAppConfig";
	public final static String Get_Schedule = BASE_URL + "/getSchedule";

	public static void AppConfigurations() throws ClientProtocolException, IOException{
	System.out.println("weell");
	String url = App_Config;
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

public static String buildjson(){
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
	return obj.toString();
}
public  static void getSchedule() throws ClientProtocolException, IOException{
	System.out.println("weell");
	String url = Get_Schedule;
	HttpClient client = new DefaultHttpClient();
	HttpPost request = new HttpPost(url);
	request.addHeader("Content-Type","application/x-www-form-urlencoded");
	List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
	urlParameters.add(new BasicNameValuePair("driver_id", "4"));
	request.setEntity(new UrlEncodedFormEntity(urlParameters));
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
public  static void reportingSession() throws ClientProtocolException, IOException{
	System.out.println("weell");
	String url = "http://52.221.226.192:8080/service/vms/updateReportingSession";
	HttpClient client = new DefaultHttpClient();
	HttpPost request = new HttpPost(url);
	request.addHeader("Content-Type","application/json");
	request.setEntity(new StringEntity(apitestcall.buildjson(),"UTF8"));
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
public static void main(String args[]) throws IOException{
	apitestcall.reportingSession(); 
	//apitestcall a1=new apitestcall();
}
}
