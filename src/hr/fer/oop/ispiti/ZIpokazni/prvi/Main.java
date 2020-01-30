package hr.fer.oop.ispiti.ZIpokazni.prvi;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main ( String[] args ) throws IOException {

        DBLoader loader = new DBLoader("/Users/matea/Downloads/drive/");
        Set<Driver> drivers = loader.loadDrivers();

        drivers.stream()
                .filter(d -> d.getAdress().equals("Zagreb"))
                .sorted((d1, d2) -> Integer.compare((int)d2.getPid(), (int)d1.getPid()))
                .forEach(d ->
                    System.out.println(d)
                );

        Set<Long> oibi = drivers.stream()
                                .filter(driver -> driver.getSurname().startsWith("M"))
                                .map(driver -> driver.getPid())
                                .collect(Collectors.toSet());
        for (Long oib: oibi)
            System.out.println(oib);

        System.out.println( drivers.stream()
                            .mapToInt(d -> d.getFirstname().length())
                            .average()
                            .getAsDouble());

    }
}
