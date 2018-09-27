package com.ecity.java.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class ReadExcel {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File excel=new File("D:\\Temp\\1.xlsx");
		
		try {
			InputStream instream = new FileInputStream(excel);
			LoadExcelFile(instream);
			instream=null;			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void LoadExcelFile(InputStream in)
	{
		try {

    	// 连接到 mongodb 服务
      MongoClient mongoClient = new MongoClient( "ls.17ecity.cc" , 57017 );
      // 连接到数据库
      MongoDatabase mongoDatabase = mongoClient.getDatabase("xj");
      MongoCollection<Document> collection = mongoDatabase.getCollection("excel2018");
      System.out.println("Connect to database successfully");

      
      
			Workbook wb = new XSSFWorkbook(in);
			
			Sheet sheet = wb.getSheetAt(0); //读取sheet 0
      int firstRowIndex = sheet.getFirstRowNum()+1;   //第一行是列名，所以不读
      int lastRowIndex = sheet.getLastRowNum();
//      System.out.println("firstRowIndex: "+firstRowIndex);
//      System.out.println("lastRowIndex: "+lastRowIndex);

      
      String SpaceStr = new String(new byte[] {-62,-96});
      
      String KeyValue="";


      int firstCellIndex1 =  sheet.getRow(0).getFirstCellNum();
      int lastCellIndex1 =  sheet.getRow(0).getLastCellNum();
      
      for (int cIndex = firstCellIndex1; cIndex < lastCellIndex1; cIndex++) {   //遍历列
      	Cell cell = sheet.getRow(0).getCell(cIndex);
      	int ColumnWidth =sheet.getColumnWidth(cIndex);

      }
      int RowList[]=new int[]{4,5,8,10,11,13,17,27,55,75};
      for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
//          System.out.println("rIndex: " + rIndex);
          Row row = sheet.getRow(rIndex);
          if (row != null) {
//          	System.out.println("");
            Document document = new Document();
            
//            String RowString ="";
            for (int i = 0; i<RowList.length;i++) {   //遍历列
            	int cIndex=RowList[i];
              Cell cell = row.getCell(cIndex);
              
              if (cell != null) {                  	
              	String cellValue = "";      
                cellValue = cell.toString();
                if (cIndex==8)
                {
									double d =cell.getNumericCellValue();                                                    
									
									Calendar base = Calendar.getInstance();   
									SimpleDateFormat outFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 									
									base.set(1899, 11, 30, 0, 0, 0);
									base.add(Calendar.DATE, (int)d);   
									base.add(Calendar.MILLISECOND,(int)((d % 1) * 24 * 60 * 60 * 1000));   
									cellValue=outFormat.format(base.getTime());   
									Date InsertDate=base.getTime();
									document.append("Row"+cIndex,InsertDate);
									if (InsertDate.getHours()<16)
									{							
										base.set(1899, 11, 30, 0, 0, 0);
										base.add(Calendar.DATE, (int)d+1);   
										document.append("EndDate",base.getTime());						
									}
									else
									{
										base.setTime(InsertDate);
										base.add(Calendar.DATE, 1);
										document.append("EndDate",base.getTime());		
									}
	                
                }
                else
                {
	                cellValue=cellValue.replace(SpaceStr, "");
	                cellValue=cellValue.replace(" ", "");
	                if (cIndex==4)
	                {
	                  KeyValue=cellValue.trim();
	                }
	                document.append("Row"+cIndex,cellValue.trim());
                }
                //System.out.println(cellValue.trim());
              }
            }
          	//System.out.println(RowString);
//            System.out.println(document.getString("Row5"));

            String Adsl=document.getString("Row5");
            if (Adsl.indexOf("ADSL")>=0)
            {
            	
            	
            	FindIterable<Document> findIterable =collection.find(Filters.eq("Row4", KeyValue));
              if (findIterable.iterator().hasNext())
              {
              	collection.updateMany(Filters.eq("Row4", KeyValue), new Document("$set",document));
              }
              else
              {
  	            List<Document> documents = new ArrayList<Document>();  
  	            documents.add(document);  
  	            collection.insertMany(documents);
              }	
            }
            
            
          }

      }

	    System.out.println("文档插入成功");  
	    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
