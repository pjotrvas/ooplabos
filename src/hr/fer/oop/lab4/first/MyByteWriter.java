package hr.fer.oop.lab4.first;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class MyByteWriter {

    private InputStream inputStream;
    private Path newFile;

    public MyByteWriter( InputStream inputStream, Path newFile ){
        this.inputStream = inputStream;
        this.newFile = newFile;
    }

    protected void createFile(Path path){
        try {
            Files.createFile(newFile);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void run(){

        if (Files.notExists(this.newFile, LinkOption.NOFOLLOW_LINKS)){
            this.createFile(this.newFile);
        }

        try (OutputStream os = Files.newOutputStream(this.newFile, StandardOpenOption.WRITE)){
            byte [] buffer = new byte[1024];
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.inputStream);
            while (true){
                int numberOfReadBytes = bufferedInputStream.read(buffer);
                if (numberOfReadBytes < 1 )break;
                os.write(buffer, 0, numberOfReadBytes);
            }

            bufferedInputStream.close();
            this.inputStream.close();
            os.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
