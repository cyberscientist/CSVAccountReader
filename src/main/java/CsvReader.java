package main.java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * This is a utility Class with a single method to read CSV.
 * Created by ali on 04/03/15.
 */
public class CsvReader {

    /**
     * This Method will read each line of the file as String and add it to a List.
     * If the line is empty it will be ignored.
     * Every Line is trimmed.
     * @param filePath
     * @return List
     * @throws IOException
     */
    static  public List<String> readCSV(String filePath) throws IOException {
        List<String> result = new ArrayList<>();
        Path path = Paths.get(filePath);

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach( l -> {
                l= l.trim();
                if (l != null && ! l.isEmpty()) {
                    result.add(l);
                }
            } );
        }
        return result;
    }
}
