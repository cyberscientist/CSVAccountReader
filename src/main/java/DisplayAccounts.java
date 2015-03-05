package main.java;

import java.util.List;

/**
 * Created by ali on 04/03/15.
 */
public class DisplayAccounts {
    private final static String displayFormat = "%-32s%-32s%-8s\n";

    public static void displayAccountsExpiryDateDescending(List<Accounts> accounts) {

        System.out.format(displayFormat, "Bank", "Card Number", "Expiry Date");
        accounts.stream()
                .sorted((a1, a2) ->
                        a1.getExpiryDate().compareTo(a2.getExpiryDate()))
                .forEach(a -> {
                    switch (a.getBank()) {
                        case "HSBC Canada":
                            System.out.format(displayFormat, a.getBank(), a.getCardNumberForDisplay(0, 1), a.getExpiryDate().toString());
                            break;
                        case "Royal Bank of Canada":
                            System.out.format(displayFormat, a.getBank(), a.getCardNumberForDisplay(0, 4), a.getExpiryDate().toString());
                            break;
                        case "American Express":
                            System.out.format(displayFormat, a.getBank(), a.getCardNumberForDisplay(15, 17), a.getExpiryDate().toString());
                            break;
                    }
                });

    }
}
