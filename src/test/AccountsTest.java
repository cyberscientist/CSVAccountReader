package test;

import main.java.Accounts;
import org.junit.Test;

import java.time.Month;
import java.time.YearMonth;

import static org.junit.Assert.*;

public class AccountsTest {

    @Test
    public void testGetCardNumberForDisplay() throws Exception {
        Accounts acc = new Accounts("HSBC","3786-7334-8965-345", YearMonth.of(2017, Month.JANUARY));
        acc.getCardNumberForDisplay(2);
    }
}