package org.hanhtrd.bank;

import java.util.HashSet;
import java.util.List;

import static java.util.Comparator.comparing;

public class StatementPrinter {

    private final Console _console;
    private final Calculator _calculator;
    private final LineFormater _lineFormater;

    public StatementPrinter(Console console, Calculator calculator, LineFormater lineFormater) {
        _console = console;
        _calculator = calculator;
        _lineFormater = lineFormater;
    }

    public void print(List<Transaction> transactions) {
        printHeader();
        if (transactions.isEmpty()) {
            return;
        }
        _calculator.calculate(new HashSet<>(transactions))
            .stream()
            .sorted(comparing(PrintableStatement::getDate).reversed())
            .map(_lineFormater::format)
            .forEach(_console::print);
    }

    private void printHeader() {
        _console.print("DATE | AMOUNT | BALANCE");
    }

    private String stringify(Transaction transaction) {
        return transaction.getDate() + " | " + stringifyAmount(transaction.getAmount()) + " | " + stringifyAmount(transaction.getAmount());
    }

    private String stringifyAmount(int amount) {
        return amount + ".00";
    }
}
