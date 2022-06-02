package org.hanhtrd.bank;

import java.util.*;
import java.util.stream.Collectors;

public class Calculator {

    public Set<PrintableStatement> calculate(Set<Transaction> transactions) {
        Set<PrintableStatement> result = new HashSet<>();
        List<Transaction> sortedTransactions = transactions
            .stream()
            .sorted(Comparator.comparing(Transaction::getDate))
            .collect(Collectors.toList());
        int totalBalance = 0;

        for (Transaction transaction : sortedTransactions) {
            totalBalance += transaction.getAmount();
            result.add(new PrintableStatement(transaction.getDate(), transaction.getAmount(), totalBalance));
        }
        return result;
    }
}
