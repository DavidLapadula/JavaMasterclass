package com.davidlapadula;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.List;

public class Secondary {

    public static void main(String[] args) {
        try (FileOutputStream binFile = new FileOutputStream("data.dat")) {
            FileChannel binChannel = binFile.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(100);
            byte[] outputBytes = "Hello World!".getBytes();
            byte[] outputBytes2 = "Nice to meet you!".getBytes();

            buffer.put(outputBytes);
            long output2Pos = outputBytes.length;
            buffer.put(outputBytes2);
            long int1Pos = output2Pos + outputBytes2.length;
            buffer.putInt(1234);
            long int2Pos = int1Pos + Integer.BYTES;
            buffer.putInt(5678);
            long int3Pos = int2Pos + Integer.BYTES;

            buffer.flip();
            binChannel.write(buffer);

            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            // Read from channel and write to buffer
            channel.read(readBuffer);
            readBuffer.flip();
            byte[] inputString = new byte[outputBytes.length];
            byte[] inputString2 = new byte[outputBytes2.length];
            readBuffer.get(inputString);
            readBuffer.get(inputString2);
            System.out.println(new String(inputString));
            System.out.println(new String(inputString2));
            System.out.println(readBuffer.getInt());
            System.out.println(readBuffer.getInt());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
