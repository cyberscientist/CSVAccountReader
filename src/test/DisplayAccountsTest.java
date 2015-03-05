package test;


import main.java.Accounts;
import main.java.DisplayAccounts;
import org.junit.Test;

import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class DisplayAccountsTest {

    @Test
    public void displayTest() {
        List<Accounts> accounts = new ArrayList<>();
        accounts.add(new Accounts("HSBC Canada", "5601-2345-3446-5678", YearMonth.of(2017, Month.NOVEMBER)));
        accounts.add(new Accounts("Royal Bank of Canada", "4519-4532-4524-2456", YearMonth.of(2017, Month.OCTOBER)));
        accounts.add(new Accounts("American Express", "3786-7334-8965-345", YearMonth.of(2018, Month.DECEMBER)));

        DisplayAccounts.displayAccountsExpiryDateDescending(accounts);
    }

}