package com.ecity.java.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Mongodb {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    try{
    	// 连接到 mongodb 服务
      MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
      
      // 连接到数据库
      MongoDatabase mongoDatabase = mongoClient.getDatabase("xj");  
      System.out.println("Connect to database successfully");

      MongoCollection<Document> collection = mongoDatabase.getCollection("test");

      System.out.println("集合 test 选择成功");
      
      Document document = new Document("title", "MongoDB").  
	    append("description", "database").  
	    append("likes", 100).  
	    append("by", "Fly");  
	    List<Document> documents = new ArrayList<Document>();  
	    documents.add(document);  
	    collection.insertMany(documents);  
	    System.out.println("文档插入成功");  
          
       
     }catch(Exception e){
       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    }
		
	}
}
