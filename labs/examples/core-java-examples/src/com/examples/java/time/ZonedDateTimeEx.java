package com.examples.java.time;

import java.time.ZonedDateTime;
import java.time.ZoneId;

public class ZonedDateTimeEx {

   public static void main(String args[]) {
	   ZonedDateTimeEx zonedDateTimeEx = new ZonedDateTimeEx();
      zonedDateTimeEx.testZonedDateTime();
   }
	
   public void testZonedDateTime() {
      // Get the current date and time
      ZonedDateTime date1 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
      System.out.println("date1: " + date1);
    		
      ZoneId id = ZoneId.of("Europe/Paris");
      System.out.println("ZoneId: " + id);
		
      ZoneId currentZone = ZoneId.systemDefault();
      System.out.println("CurrentZone: " + currentZone);
   }
}