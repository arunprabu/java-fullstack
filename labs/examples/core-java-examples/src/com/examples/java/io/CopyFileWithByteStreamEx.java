package com.examples.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.examples.java.exception.CustomException;

public class CopyFileWithByteStreamEx {

   public static void main(String args[]) throws CustomException, IOException {  

	   // try with resources
      try(FileInputStream in = new FileInputStream("D:\\Temp\\input.txt"); 
    	  FileOutputStream out = new FileOutputStream("D:\\Temp\\output.txt"))
      {                 
         int c;
         while ((c = in.read()) != -1) {
        	out.write(c);
         }         
  
         System.out.println("File copied successfully.");         
       
      }catch(FileNotFoundException e)
      {
    	  // throw new CustomException("Error occured - file not found - " + e.getMessage());
    	  System.out.println("Error occured - file not found - " + e.getMessage());
    	  e.printStackTrace();
      } 
      // Not required as stream will be auto closed when using try with resources
//      finally {
//    	 System.out.println("Finally called...");
//         if (in != null) {
//            in.close();
//         }
//         if (out != null) {
//            out.close();
//         }
//      }
   }
}