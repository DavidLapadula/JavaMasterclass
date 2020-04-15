package com.davidlapadula;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (FileOutputStream binFile = new FileOutputStream("data.dat")) {

            FileChannel binChannel = binFile.getChannel();

            byte[] outputBytes = "Hello World!".getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
            buffer.put(outputBytes);
            buffer.flip();

            int numBytes = binChannel.write(buffer);
            System.out.println("Bytes :" + numBytes);

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("Bytes :" + numBytes);

            intBuffer.flip();
            intBuffer.putInt(-98765);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("Bytes :" + numBytes);

//          RAF with NIO
            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();
            buffer.flip();
            long numBytesRead = channel.read(buffer);
            if (buffer.hasArray()) {
                System.out.println("Byte buffer = " + new String(buffer.array()));
            }

//            RAF with IO
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            byte[] b = new byte[outputBytes.length];
//            ra.read(b);
//            System.out.println(new String(b));
//
//            long int1 = ra.readInt();
//            long int2 = ra.readInt();

//          Absolute Read
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt(0));

//             Relative Read
//             intBuffer.flip();
//             numBytesRead = channel.read(intBuffer);
//             intBuffer.flip();
//             System.out.println(intBuffer.getInt());
//             intBuffer.flip();
//             numBytesRead = channel.read(intBuffer);
//             intBuffer.flip();
//             System.out.println(intBuffer.getInt());
//             channel.close();
//             ra.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
