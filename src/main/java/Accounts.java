package main.java;

import java.time.YearMonth;

/**
 * Created by ali on 04/03/15.
 */
public class Accounts {
    private final String bank;
    private final String cardNumber;
    private final YearMonth expiryDate;
    private final int indexOfStartPosition;
    private final int indexOfEndPosition;

    public Accounts(String bank, String cardNumber, YearMonth expiryDate, int indexOfStartPosition, int indexOfEndPosition) {
        this.bank = bank;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        validateMaskingParameters(indexOfEndPosition, indexOfStartPosition);
        this.indexOfStartPosition = indexOfStartPosition;
        this.indexOfEndPosition = indexOfEndPosition;
    }

    public String getCardNumberForDisplay() {

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
