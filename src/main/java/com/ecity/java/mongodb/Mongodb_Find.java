package com.ecity.java.mongodb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Mongodb_Find {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    try{
    	// 连接到 mongodb 服务
      MongoClient mongoClient = new MongoClient( "ls.17ecity.cc" , 57017 );
      
      // 连接到数据库
      MongoDatabase mongoDatabase = mongoClient.getDatabase("xj");  
      System.out.println("Connect to database successfully");

      MongoCollection<Document> collection = mongoDatabase.getCollection("excel2018");

      System.out.println("集合 test 选择成功");
      

      BasicDBObject  query = new BasicDBObject();

			 
			//查询两个时间范围的，用map包装一下
	     BasicDBList queryRow15 = new BasicDBList();  
			
			
			queryRow15.add("ADSL拨号移机");
			queryRow15.add("ADSL拨号新装");
			queryRow15.add("预付费ADSL拨号移机");
			queryRow15.add("ADSL专线新装");
			query.put("Row15", new BasicDBObject("$in",queryRow15));
			
			


 
			//查询两个时间范围的，用map包装一下
			Map<String, Object> queryDate = new HashMap<String, Object>();
			
			Calendar base = Calendar.getInstance();   
						
			Date now=new Date();
			//Date InsertDate=base.getTime();
			base.setTime(now);
			base.set(base.HOUR, -12);
			base.set(base.MINUTE, 0);
			base.set(base.SECOND, 0);
			base.set(base.MILLISECOND, 0);
			queryDate.put("$gt",base.getTime());
 		//	query.put("EndDate", new BasicDBObject(queryDate));
 			
// 			query.put("$and","[{\"EndDate\":{$gt:"+base.getTime()+"}},{\"Row10\",\"新装/\"}]");

 			System.out.println(query.toJson());
 			FindIterable<Document> findIterable =collection.find(query).sort(new BasicDBObject("EndDate",-1)); 			
 			
 			
    	
      MongoCursor<Document> mongoCursor = findIterable.iterator();  
      while(mongoCursor.hasNext()){  
      	Document document = mongoCursor.next();
        System.out.println(document.getString("Row5"));  
        System.out.println(document.toJson());  
      }  
     }catch(Exception e){
       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    }
		
	}
}
