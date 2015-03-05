package main.java;

import java.util.List;

/**
 * Created by ali on 04/03/15.
 */
class DisplayAccounts {
    private final static String displayFormat = "%-32s%-32s%-8s\n";

    /**
     * Sorts a list of accounts by expiry date and prints to terminal.
     *
     * @param accounts
     */
    public static void displayAccountsExpiryDateDescending(List<Accounts> accounts) {

        System.out.format(displayFormat, "Bank", "Card Number", "Expiry Date");
        accounts.stream()
                .sorted((a1, a2) ->
                        a1.getExpiryDate().compareTo(a2.getExpiryDate()))
                .forEach(a ->
                                System.out.format(displayFormat, a.getBank(), a.getCardNumberForDisplay(), a.getExpiryDate().toString())
                );
    }
}
