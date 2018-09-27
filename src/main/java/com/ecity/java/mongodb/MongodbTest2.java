package com.ecity.java.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongodbTest2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    try{
    	// 连接到 mongodb 服务
      MongoClient mongoClient = new MongoClient( "ls.17ecity.cc" , 57017 );
      // 连接到数据库
      MongoDatabase mongoDatabase = mongoClient.getDatabase("ls");  
      System.out.println("Connect to database successfully");

      for (int i=1;i<1000;i++)
      {
	      MongoCollection<Document> collection = mongoDatabase.getCollection("alitripTravelTrade");
	      
	        
	 			FindIterable<Document> findIterable =collection.find(Filters.eq("OrderID","011924116"));
	      MongoCursor<Document> mongoCursor = findIterable.iterator();  
	      while(mongoCursor.hasNext()){  
	      	Document document = mongoCursor.next();
//	        System.out.println(document.toJson());  
	      	System.out.println(""+i);
	      }
      }   
       
     }catch(Exception e){
       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    }
		
	}
}
