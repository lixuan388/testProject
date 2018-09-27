package com.ecity.java.web.testProject;

import java.util.Calendar;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        

  			Calendar base = Calendar.getInstance();   
  						
  			Date now=new Date();
  			//Date InsertDate=base.getTime();
  			

  			System.out.println(now.toString());
  			base.setTime(now);
  			base.set(base.HOUR, -12);
  			base.set(base.MINUTE, 0);
  			base.set(base.SECOND, 0);
  			base.set(base.MILLISECOND, 0);
  			
  			
  			now=base.getTime();
  			System.out.println(now.toString());
        
    }
}
