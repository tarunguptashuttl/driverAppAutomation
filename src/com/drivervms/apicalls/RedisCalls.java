//package com.drivervms.apicalls;
//
//import java.util.List;
//
//import redis.clients.jedis.Jedis;
//
//public class RedisCalls {
//   public static void main(String[] args) {
//      //Connecting to Redis server on localhost
//	 System.out.println("starts here");
//	   Jedis jedis = new Jedis("qa-driver-redis.goplus.in");
//      System.out.println("Connection to server sucessfully");
//      //check whether server is running or not
//      System.out.println(jedis.keys("driverid_4"));
////      List<String> allkeys = jedis.keys("*");
////      for(int i=0; i<allkeys.size(); i++) {
////        System.out.println("List of stored keys:: "+allkeys.get(i));
//      System.out.println("Server is running: "+jedis.ping());
// }
//}