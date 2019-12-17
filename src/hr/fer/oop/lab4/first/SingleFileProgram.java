package hr.fer.oop.lab4.first;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class SingleFileProgram {

    public static void main ( String[] args ) {

        Path original = Paths.get("/Users/matea/Downloads/racuni3/2015/9/Racun_8.txt");
        Path result = Paths.get("/Users/matea/Downloads/singleout.txt");

        try (InputStream is = Files.newInputStream(original, StandardOpenOption.READ)){

            MyByteWriter rewriter = new MyByteWriter(is, result);
            rewriter.run();
            System.out.println(filesEquals(original, result));

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static boolean filesEquals(Path f1, Path f2) throws IOException {
        return Arrays.equals(Files.readAllBytes(f1), Files.readAllBytes(f2));
    }
}
