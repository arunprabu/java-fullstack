package com.examples.java.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyFileWithByteChannelEx {

	public static void main(String[] args) throws IOException
	{
		// create a path for file named temp.txt from current folder
		Path filePath = FileSystems.getDefault().getPath("D:\\Temp\\input.txt");

		// read a complete file in one go as byte array
		// use this to read small files
		byte[] byteArray = Files.readAllBytes(filePath);

		Path fileCopy = FileSystems.getDefault().getPath("D:\\Temp\\output.txt");
		Files.write(fileCopy, byteArray);
		
		System.out.println("File copied successfully.");
	}
}


