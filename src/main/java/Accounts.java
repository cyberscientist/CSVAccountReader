package main.java;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ali on 04/03/15.
 */
public class Accounts {
    private String bank;
    private String cardNumber;
    private YearMonth expiryDate;

    public Accounts (String bank, String cardNumber, YearMonth expiryDate) {
        this.bank=bank;
        this.cardNumber=cardNumber;
        this.expiryDate=expiryDate;
    }

    public String getBank() {
        return bank;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardNumberForDisplay(int NumberDigitsToUnmask, int indexOfStartPosition) {

        if (NumberDigitsToUnmask >= getCardNumber().length() ||
                indexOfStartPosition > getCardNumber().length() ||
                indexOfStartPosition < 0) {
            throw new IllegalArgumentException("Not a Valid Set Of Number!");
        }

        StringBuilder results = new StringBuilder();
        getCardNumber().chars().


    }

    public YearMonth getExpiryDate() {
        return expiryDate;
    }

    @FunctionalInterface
    public interface LoopWithIndexAndSizeConsumer<T> {
        void accept(int i, int n);
    }
    public static <T> void forEach(Collection<T> collection,
                                   LoopWithIndexAndSizeConsumer<T> consumer) {
        int index = 0;
        for (T object : collection){
            consumer.accept( index++, collection.size());
        }
    }
}
