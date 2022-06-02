package org.hanhtrd.bank;

import java.util.HashSet;
import java.util.List;

import static java.util.Comparator.comparing;

public class StatementPrinter {

    private final Console _console;
    private final Calculator _calculator;
    private final LineFormater _lineFormatter;

    public StatementPrinter(Console console, Calculator calculator, LineFormater lineFormatter) {
        _console = console;
        _calculator = calculator;
        _lineFormatter = lineFormatter;
    }

    public void print(List<Transaction> transactions) {
        printHeader();
        if (transactions.isEmpty()) {
            return;
        }
        _calculator.calculate(new HashSet<>(transactions))
            .stream()
            .sorted(comparing(PrintableStatement::getDate).reversed())
            .map(_lineFormatter::format)
            .forEach(_console::print);
    }

    private void printHeader() {
        _console.print("DATE | AMOUNT | BALANCE");
    }
}
