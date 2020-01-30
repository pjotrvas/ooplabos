package hr.fer.oop.ispiti.ZIpokazni.prvi;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DBLoader extends SimpleFileVisitor<Path> {

    private File[] files;
    private Set<Driver> drivers= new LinkedHashSet <>();

    public DBLoader(String pathname){

       files = new File(pathname).listFiles(new FilenameFilter() {
           @Override
           public boolean accept ( File dir , String name ) {
               return name.endsWith(".txt");
           }
       });
    }

    public Set<Driver> loadDrivers() throws IOException{
        for (File file: files){
            BufferedReader reader= new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line!=null){
                String[] parts = line.split(",");
                drivers.add(new Driver(parts[0].trim(), parts[1].trim(), parts[2].trim(), Long.parseLong(parts[3].trim())));
                line = reader.readLine();
            }
            reader.close();
        }
        return drivers;
    }


}
