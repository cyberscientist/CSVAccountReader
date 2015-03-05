package main.java;

import java.time.YearMonth;

/**
 * Created by ali on 04/03/15.
 */
public class Accounts {
    private final String bank;
    private final String cardNumber;
    private final YearMonth expiryDate;

    public Accounts(String bank, String cardNumber, YearMonth expiryDate) {
        this.bank = bank;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    public String getCardNumberForDisplay(int indexOfStartPosition, int indexOfEndPosition) {

        validateMaskingParameters(indexOfEndPosition, indexOfStartPosition);

        StringBuilder results = new StringBuilder();
        for (int i = 0; i < getCardNumber().length(); i++) {
            if (getCardNumber().charAt(i) == '-') {
                results.append('-');
                continue;
            }

            if (i >= indexOfStartPosition && i <= indexOfEndPosition) {
                results.append(getCardNumber().charAt(i));
            } else {
                results.append('X');
            }
        }

        return results.toString();
    }

    private void validateMaskingParameters(int indexOfStartPosition, int indexOfEndPosition) {
        if (indexOfEndPosition >= getCardNumber().length() ||
                indexOfStartPosition > getCardNumber().length() ||
                indexOfStartPosition < 0) {
            throw new IllegalArgumentException("Not a Valid Set Of Number!");
        }
    }

    public String getBank() {
        return bank;
    }

    public String getCardNumber() {
        return cardNumber;
    }


    public YearMonth getExpiryDate() {
        return expiryDate;
    }
}
