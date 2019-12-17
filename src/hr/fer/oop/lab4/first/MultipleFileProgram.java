package hr.fer.oop.lab4.first;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.*;

public class MultipleFileProgram {

    public static void main ( String[] args ) {
        Path racuni = Paths.get("/Users/matea/Downloads/racuni3");
        Path sviracuni = Paths.get("/Users/matea/Downloads/sviRacuni.txt");

        if (Files.notExists(sviracuni, LinkOption.NOFOLLOW_LINKS)) createFile(sviracuni);

        try {
            OutputStream outputStream = Files.newOutputStream(sviracuni, StandardOpenOption.WRITE);
            FileVisitor<Path> visitor = new MyByteReader(outputStream);
            Files.walkFileTree(racuni, visitor);
            outputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void createFile(Path path){
        try {
            Files.createFile(path);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
