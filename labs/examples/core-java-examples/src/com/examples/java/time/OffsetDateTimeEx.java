package com.examples.java.time;

import java.time.OffsetDateTime;

public class OffsetDateTimeEx {

   public static void main(String args[]) {
	   OffsetDateTimeEx localDateTimeEx = new OffsetDateTimeEx();
      localDateTimeEx.testLocalDateTime();
   }
	
   public void testLocalDateTime() {
	   
	   // Get offset time with UTC+5.30
	   OffsetDateTime offsetDateTime = OffsetDateTime.now();
	   System.out.println(offsetDateTime);
	         
   }
}
