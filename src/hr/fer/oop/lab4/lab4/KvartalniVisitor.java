package hr.fer.oop.lab4.lab4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;

public class KvartalniVisitor extends SimpleFileVisitor<Path> {

    private HashMap<Integer,String> kvartali;

    public KvartalniVisitor(){
        kvartali = new HashMap<>();
    }

    public HashMap<Integer, String> getKvartali() {
        return kvartali;
    }

    @Override
    public FileVisitResult preVisitDirectory( Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(file.toString().endsWith(".txt")) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(file)));
            String mjesec = file.getParent().getFileName().toString();
            //System.out.println("Upravo posjetih " + mjesec );
            Double iznos = null;
            String redniBrojRacuna = null;
            String outputLine = "";

            int kvartal = 0;
            if(mjesec.equals("1") || mjesec.equals("2") || mjesec.equals("3")) kvartal = 1;
            else if (mjesec.equals("4") || mjesec.equals("5") || mjesec.equals("6")) kvartal = 2;
            else if (mjesec.equals("7") || mjesec.equals("8") || mjesec.equals("9")) kvartal = 3;
            else if (mjesec.equals("10") || mjesec.equals("11") || mjesec.equals("12")) kvartal = 4;
            else System.err.println("Nepostojeci mjesec!!!");

            while (true) {
                String line = bufferedReader.readLine();
                if(line==null) break;

                if(line.startsWith("Račun br.")) {
                    redniBrojRacuna = line;
                }

                if(line.startsWith("UKUPNO")) {
                    String[] parts = line.split("\\s+");
                    iznos = Double.parseDouble(parts[1]);
                    outputLine = redniBrojRacuna + "  UKUPNO: " + iznos.toString() + "\n";
                    break;
                }
            }

            System.out.println(outputLine + "kvartal: " + kvartal);

            if(!kvartali.containsKey(kvartal)) {
                kvartali.put(kvartal,outputLine);
            } else {
                kvartali.replace(kvartal, kvartali.get(kvartal)+outputLine);
            }
        }

        return FileVisitResult.CONTINUE;
    }
}