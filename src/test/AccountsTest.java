package test;

import main.java.Accounts;
import org.junit.Test;

import java.time.Month;
import java.time.YearMonth;

import static org.junit.Assert.assertEquals;


public class AccountsTest {

    @Test
    public void testGetCardNumberForDisplay() throws Exception {
        Accounts acc = new Accounts("HSBC", "3786-7334-8965-345", YearMonth.of(2017, Month.JANUARY), 0, 3);
        assertEquals("3786-XXXX-XXXX-XXX", acc.getCardNumberForDisplay());

        Accounts acc2 = new Accounts("Royal Bank of  Canada", "4519-4532-4524-2456", YearMonth.of(2017, Month.OCTOBER), 5, 8);
        assertEquals("XXXX-4532-XXXX-XXXX", acc2.getCardNumberForDisplay());
    }
}