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

//            Writing non-sequentially, calculate start positions first
            byte[] outputString = "Hello World!".getBytes();
            byte[] outputString2 = "Nice to meet you!".getBytes();
            long str1Pos = 0;
            long newInt1Pos = outputString.length;
            long newInt2Pos = newInt1Pos + Integer.BYTES;
            long str2Pos =  newInt2Pos + Integer.BYTES;
            long newInt3Pos = str2Pos + outputString2.length;

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//             Put it in buffer, then write to the channel
            intBuffer.putInt(245);
            intBuffer.flip();
            binChannel.position(newInt1Pos);
            binChannel.write(intBuffer);

            intBuffer.flip();
            intBuffer.putInt(-98765);
            intBuffer.flip();
            binChannel.position(newInt2Pos);
            binChannel.write(intBuffer);

            intBuffer.flip();
            intBuffer.putInt(1000);
            intBuffer.flip();
            binChannel.position(newInt3Pos);
            binChannel.write(intBuffer);

            binChannel.position(str1Pos);
            binChannel.write(ByteBuffer.wrap(outputString));
            binChannel.position(str2Pos);
            binChannel.write(ByteBuffer.wrap(outputString2));

            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat", "rw");
            FileChannel copyChannel = copyFile.getChannel();
            channel.position(0);
            long numTransferred = copyChannel.transferFrom(channel, 0, channel.size());
//            long numTransferred = channel.transferTo(0, channel.size(), copyChannel);
            System.out.println("Transferred: " + numTransferred);

            channel.close();
            ra.close();
            copyChannel.close();

//            Reading Backward
//            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
//            channel.position(int3Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int 3 =" + readBuffer.getInt());
//
//            readBuffer.flip();
//            channel.position(int2Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int 2 =" + readBuffer.getInt());
//
//            channel.position(int1Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int 1 =" + readBuffer.getInt());


//            Reading Forward
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
