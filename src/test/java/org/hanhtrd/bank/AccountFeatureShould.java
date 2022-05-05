package org.hanhtrd.bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.inOrder;

// Acceptance test
@ExtendWith(MockitoExtension.class)
public class AccountFeatureShould {

    @Mock
    private Console console;

    @Test public void
    print_bank_statement_to_the_console() {
        // Arrange
        TransactionRepository repository = new TransactionRepository(new Clock());
        StatementPrinter statementPrinter = new StatementPrinter(new Console());
        Account account = new Account(repository, statementPrinter);
        account.deposit(1_000);
        account.withdrawal(100);
        account.deposit(500);

        // Act
        account.printStatement();

        // Assert
        InOrder inOrder = inOrder(console);
        inOrder.verify(console).print("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).print("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).print("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).print("01/04/2014 | 1000.00 | 1000.00");
    }
}
