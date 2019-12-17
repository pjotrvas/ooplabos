package hr.fer.oop.lab4.first;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class MyByteReader extends SimpleFileVisitor <Path> {

    public BufferedOutputStream bufferedOutputStream;

    public MyByteReader( OutputStream outputStream ){
        this.bufferedOutputStream = new BufferedOutputStream( outputStream );
    }

    @Override
    public FileVisitResult preVisitDirectory ( Path dir , BasicFileAttributes attrs ) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile ( Path file , BasicFileAttributes attrs ) throws IOException {
        System.out.println("Reading file: " + file.toString());

        if (file.toString().endsWith("txt")){
            BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(file, StandardOpenOption.READ));
            byte [] buffer = new byte[1024];
            while (true){
                int numOfReadBytes = bufferedInputStream.read(buffer);
                if (numOfReadBytes < 1) break;
                bufferedOutputStream.write(buffer, 0, numOfReadBytes);
            }
            bufferedInputStream.close();
            bufferedOutputStream.flush();
        }



        return FileVisitResult.CONTINUE;
    }



    @Override
    public FileVisitResult postVisitDirectory ( Path dir , IOException exc ) throws IOException {
        System.out.println("Directory sent to buffer: " + dir.toString());
        return FileVisitResult.CONTINUE;
    }
}
