package test;

import main.java.CsvReader;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class CsvReaderTest {

    @Test
    public void testReadCSV() throws Exception {

        List<String> result = CsvReader.readCSV(Paths.get("src/test/accounts.csv").toAbsolutePath().toString());
        //empty lines and spaces are ignored
        assertEquals(8, result.size());
        //test Trims
        assertEquals("Test,", result.get(0));
        assertEquals("World", result.get(2));

    }
}