package org.hanhtrd.bank;

import java.util.List;

public class StatementPrinter {

    private final Console _console;

    public StatementPrinter(Console console) {
        _console = console;
    }

    public void print(List<Transaction> transactions) {
        _console.print("DATE | AMOUNT | BALANCE");
        if (transactions.isEmpty()) {
            return;
        }
        Transaction transaction = transactions.get(0);
        _console.print(stringify(transaction));
    }

    private String stringify(Transaction transaction) {
        return transaction.getDate() + " | " + transaction.getAmount() + " | " + transaction.getAmount();
    }
}
