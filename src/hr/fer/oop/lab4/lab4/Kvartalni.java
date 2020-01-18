package hr.fer.oop.lab4.lab4;

import java.io.*;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Kvartalni {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite godinu za koju zelite kvartalni izvjestaj: ");
        String year = "";

        while (true) {
            year = sc.next();
            if(year.trim().length() != 4)
                System.err.println("Neispravno unesena godina!");
            else
                break;
        }

        Path path = Paths.get("/Users/matea/Downloads/racuni3/" + year);
        FileVisitor<Path> visitor = new KvartalniVisitor();

        try {
            Files.walkFileTree(path,visitor);
            String fileName = "report"+year+"-";


            for(int i = 1; i <= 4; i++) {
                String values = ((KvartalniVisitor) visitor).getKvartali().get(i);
                String[] parts = values.split("\\n");
                int ukupno = 0;
                double suma = 0;
                for(String part : parts) {
                    if (part.contains("UKUPNO:")) {
                        ukupno++;
                        try {
                            String parts2[] = part.split("\\s+");
                            suma += Double.parseDouble(parts2[4]);
                        } catch (NumberFormatException e) {
                            System.out.println("Vrijednost" + e.getCause() +" nije double!");
                        }
                    }
                }

                Writer bw = new BufferedWriter(
                        new OutputStreamWriter(
                                new BufferedOutputStream(new FileOutputStream("/Users/matea/Downloads/"+fileName+i+".txt"))
                                ,"UTF-8")
                );
                if (i == 1) bw.write(year + "\n" + i + ". kvartal" + "(" + i + "-" + (i*3) + ")\n" + "Ukupno racuna: " + ukupno + "\n" + values +  "\nUKUPNI PDV: " + suma);
                if (i == 2) bw.write(year + "\n" + i + ". kvartal" + "(" + (i+2) + "-" + (i*3) + ")\n" + "Ukupno racuna: " + ukupno + "\n" + values +  "\nUKUPNI PDV: " + suma);
                if (i == 3) bw.write(year + "\n" + i + ". kvartal" + "(" + (i+4) + "-" + (i*3) + ")\n" + "Ukupno racuna: " + ukupno + "\n" + values +  "\nUKUPNI PDV: " + suma);
                if (i == 4) bw.write(year + "\n" + i + ". kvartal" + "(" + (i+6) + "-" + (i*3) + ")\n" + "Ukupno racuna: " + ukupno + "\n" + values +  "\nUKUPNI PDV: " + suma);
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}