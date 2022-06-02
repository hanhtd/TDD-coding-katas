package org.hanhtrd.bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StatementPrinterShould {

    @Mock
    private Console _console;

    @Mock
    private Calculator _calculator;
    @Mock
    private LineFormater _lineFormatter;
    @Captor
    private ArgumentCaptor<String> printableLines;

    @Test
    public void
    print_statement_header() {
        StatementPrinter statementPrinter = new StatementPrinter(_console, _calculator, _lineFormatter);

        statementPrinter.print(emptyList());

        verify(_console).print("DATE | AMOUNT | BALANCE");
    }

    @Test
    public void
    print_header_and_all_transactions_in_order() {
        StatementPrinter statementPrinter = new StatementPrinter(_console, _calculator, _lineFormatter);
        when(_calculator.calculate(eq(Set.of(
            new Transaction("02/05/2014", 1550),
            new Transaction("01/04/2014", 1000)
        )))).thenReturn(Set.of(
            new PrintableStatement("01/04/2014", 1_000, 1_000),
            new PrintableStatement("02/05/2014", 1_550, 2_550)
        ));
        when(_lineFormatter.format(refEq(new PrintableStatement("01/04/2014", 1_000, 1_000))))
            .thenReturn("01/04/2014 | 1000.00 | 1000.00");
        when(_lineFormatter.format(refEq(new PrintableStatement("02/05/2014", 1_550, 2_550))))
            .thenReturn("02/05/2014 | 1550.00 | 2550.00");

        statementPrinter.print(List.of(
            new Transaction("01/04/2014", 1000),
            new Transaction("02/05/2014", 1550)
        ));

        verify(_console, times(3)).print(printableLines.capture());
        assertThat(printableLines.getAllValues()).containsExactly(
            "DATE | AMOUNT | BALANCE",
            "02/05/2014 | 1550.00 | 2550.00",
            "01/04/2014 | 1000.00 | 1000.00"
        );
    }
    @Test
    public void
    print_header_and_all_transactions() {
        StatementPrinter statementPrinter = new StatementPrinter(_console, _calculator, _lineFormatter);
        when(_calculator.calculate(eq(Set.of(
            new Transaction("02/05/2014", 1550),
            new Transaction("01/04/2014", 1000)
        )))).thenReturn(Set.of(
            new PrintableStatement("01/04/2014", 1_000, 1_000),
            new PrintableStatement("02/05/2014", 1_550, 2_550)
        ));
        when(_lineFormatter.format(refEq(new PrintableStatement("01/04/2014", 1_000, 1_000))))
            .thenReturn("01/04/2014 | 1000.00 | 1000.00");
        when(_lineFormatter.format(refEq(new PrintableStatement("02/05/2014", 1_550, 2_550))))
            .thenReturn("02/05/2014 | 1550.00 | 2550.00");

        statementPrinter.print(List.of(
            new Transaction("01/04/2014", 1000),
            new Transaction("02/05/2014", 1550)
        ));

        verify(_console, times(3)).print(printableLines.capture());
        assertThat(printableLines.getAllValues()).containsExactlyInAnyOrder(
            "DATE | AMOUNT | BALANCE",
            "02/05/2014 | 1550.00 | 2550.00",
            "01/04/2014 | 1000.00 | 1000.00"
        );
    }

    @Test
    public void test_transaction_is_sorted() {
        StatementPrinter statementPrinter = new StatementPrinter(_console, _calculator, _lineFormatter);

        statementPrinter.print(List.of(
            new Transaction("01/04/2014", 1000),
            new Transaction("02/05/2014", 1550)
        ));

        verify(_calculator).calculate(Set.of(
            new Transaction("02/05/2014", 1550),
            new Transaction("01/04/2014", 1000)
        ));
    }
}