package main.java;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by ali on 05/03/15.
 */
class Runner {

    public static void main(String[] args) {
        String path = Paths.get("src/main/java/accounts.csv").toAbsolutePath().toString();
        List stringAccounts = null;
        try {
            stringAccounts = CsvReader.readCSV(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Converter convertor = new CommaSeparatedStringToAccountsConverter();
        List accounts = convertor.convert(stringAccounts);
        DisplayAccounts.displayAccountsExpiryDateDescending(accounts);
    }


}
