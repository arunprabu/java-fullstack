package com.examples.java.io;

import java.io.*;
import java.util.Scanner;
 
public class ReadFileDataWithScannerEx {
    public static void main(String[] args) throws IOException {
 
        Scanner s = null;
 
        try {
            s = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("D:\\\\Temp\\\\output.txt"))));
            
            while (s.hasNextLine()) {
                System.out.println(s.nextLine());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
