package main.java;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ali on 04/03/15.
 */
 public class CommaSeparatedStringToAccountsConverter implements Converter {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yyyy");

    /**
     * Converts comma separated String to accounts.
     * Assumes default start and end position for masking to be 0 and 4 respectively.
     * Assumes the expiry date format to be "MMM-yyyy".
     *
     * @param items List of Strings
     * @return List
     */
    @Override
    public List<Accounts> convert(List<String> items) {
        List<Accounts> accounts = new ArrayList<>();
        if ( items == null || items.isEmpty()){
            return accounts;
        }

        items.stream().filter(i-> i != null).forEach(i -> {

            String[] strngArry = i.split(",");
            if (0 == Arrays.stream(strngArry).filter(s -> (s == null ||s.isEmpty() )).count() && strngArry.length != 0) {
                String bnk = strngArry[0].trim();
                String crdNmbr = strngArry[1].trim();
                YearMonth ym = YearMonth.parse(strngArry[2].trim(), formatter);
                int sp = 0;
                int ep = 4;
                for (BanksConfig bc : BanksConfig.values()) {
                    if (bc.getName().equals(bnk)) {
                        sp = bc.getStartPosition();
                        ep = bc.getEndPosition();

                    }
                }
                accounts.add(new Accounts(bnk, crdNmbr, ym, sp, ep));
            }

        });
        return accounts;
    }
}

