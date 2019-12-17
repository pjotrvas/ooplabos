package hr.fer.oop.lab4.second;

import java.io.*;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeSet;

public class Program {

    public static void main ( String[] args ) {
        FileVisitor<Path> visitor= new MySecondByteReader();
        Path racuni = Paths.get("/Users/matea/Downloads/racuni3");

        try {
            Files.walkFileTree(racuni, visitor);
            TreeSet<Artikl> artikli = ((MySecondByteReader) visitor).getArticles();
            Writer writer1 = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("/Users/matea/Downloads/cjenik.88592.txt")),"ISO-8859-2"));
            Writer writer2 = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("/Users/matea/Downloads/cjenik.utf8.txt")),"UTF-8"));

            for (Artikl a: artikli) {
                System.out.println(a.getNaziv() + ";" + a.getCijena());
                writer1.write(a.getNaziv()+ "\t" + a.getCijena() + "\n");
                writer2.write(a.getNaziv()+ "\t" + a.getCijena() + "\n");
            }
            writer1.close();
            writer2.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
