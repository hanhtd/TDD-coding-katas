package org.hanhtrd.bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StatementPrinterShould {

    @Mock
    private Console console;

    @Test
    public void
    print_statement_header() {
        StatementPrinter statementPrinter = new StatementPrinter(console);

        statementPrinter.print(emptyList());

        verify(console).print("DATE | AMOUNT | BALANCE");
    }

    @Test
    public void
    print_bank_transfer() {
        StatementPrinter statementPrinter = new StatementPrinter(console);

        statementPrinter.print(asList(new Transaction("01/04/2014", 1000)));

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).print("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).print("01/04/2014 | 1000.00 | 1000.00");
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void
    print_bank_transfers_with_recent_order() {

    }

    @Test
    public void
    print_bank_transfers_with_running_balance() {

    }
}