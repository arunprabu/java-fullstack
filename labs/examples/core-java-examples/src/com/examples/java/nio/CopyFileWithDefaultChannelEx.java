package com.examples.java.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;

public class CopyFileWithDefaultChannelEx {

	public static void main(String[] args) throws IOException
	{
		// create a path for file named temp.txt from current folder
		Path filePath = FileSystems.getDefault().getPath("D:\\Temp\\input.txt");

		SeekableByteChannel srcByteChannel = Files.newByteChannel(filePath);
		ByteBuffer byteBuffer = ByteBuffer.allocate(10);

		Charset charset = Charset.forName("US-ASCII");
		while (srcByteChannel.read(byteBuffer) > 0) {
			byteBuffer.rewind();
			System.out.print(charset.decode(byteBuffer));
			byteBuffer.flip();
		}

		Path fileCopy = FileSystems.getDefault().getPath("D:\\Temp\\output.txt");
		
		Set options = new HashSet();
		options.add(StandardOpenOption.CREATE);
		options.add(StandardOpenOption.APPEND);		
		
		SeekableByteChannel targetbyteChannel = Files.newByteChannel(fileCopy, options);
		targetbyteChannel.write(byteBuffer);
		
//		Files.write(fileCopy, byteArray);
		
		System.out.println("File copied successfully.");
	}
}


