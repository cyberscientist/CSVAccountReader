package test;

import main.java.Accounts;
import org.junit.Test;
import main.java.CommaSeparatedStringToAccountsConverter;

import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CommaSeparatedStringToAccountsConverterTest {

    @Test
    public void testConvert() throws Exception {
        List<String> accounts = new ArrayList<>();
        accounts.add("HSBC Canada,5601-2345-3446-5678,Nov-2017");
        accounts.add("Royal Bank of  Canada,4519-4532-4524-2456,Oct-2017");
        accounts.add("American Express,3786-7334-8965-345,Dec-2018");

        accounts.add("  Americana Expressa  , 3786-7334-8965-666   ,     Dec-2018    ");
        accounts.add(",  5601-2345-3446-5678, Nov-2017");
        accounts.add(",,,");
        accounts.add(null);
        CommaSeparatedStringToAccountsConverter converter = new CommaSeparatedStringToAccountsConverter();
        List<Accounts> results = converter.convert(accounts);

        //check for dates
        assertEquals(YearMonth.of(2017, Month.NOVEMBER), results.get(0).getExpiryDate());
        assertEquals(YearMonth.of(2017, Month.OCTOBER), results.get(1).getExpiryDate());
        //check for bank names
        assertEquals("American Express", results.get(2).getBank());
        //check for account numbers
        assertEquals("3786-7334-8965-345", results.get(2).getCardNumber());
        //check for trim
        assertEquals("3786-7334-8965-666", results.get(3).getCardNumber());
        assertEquals("Americana Expressa", results.get(3).getBank());

        //chek for empty values
        assertEquals(0, results.stream().filter(a -> a.getBank().isEmpty()).count());
        assertEquals(0,results.stream().filter(a -> a == null).count());
        //list going in could be null

        assertTrue(converter.convert(new ArrayList<>()).isEmpty());
        assertTrue(converter.convert(null).isEmpty());

    }
}