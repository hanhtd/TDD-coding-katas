package org.hanhtrd.bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

// Acceptance test
@ExtendWith(MockitoExtension.class)
public class AccountFeatureShould {

    @Spy
    private Console console = new Console();
    @Captor
    ArgumentCaptor<String> statements;
    @Spy
    private Clock clock = new Clock();

    @Test public void
    print_bank_statement_to_the_console() {
        // Arrange
        TransactionRepository repository = new TransactionRepository(clock);
        StatementPrinter statementPrinter = new StatementPrinter(console, new Calculator(), new LineFormater());
        when(clock.now())
            .thenReturn(LocalDate.of(2014, 4, 1))
            .thenReturn(LocalDate.of(2014, 4, 2))
            .thenReturn(LocalDate.of(2014, 4, 10));
        Account account = new Account(repository, statementPrinter);
        account.deposit(1_000);
        account.withdrawal(100);
        account.deposit(500);

        // Act
        account.printStatement();

        // Assert
        verify(console, times(4)).print(statements.capture());
        List<String> printed = statements.getAllValues();
        assertThat(printed).containsExactly(
            "DATE | AMOUNT | BALANCE",
            "10/04/2014 | 500.00 | 1400.00",
            "02/04/2014 | -100.00 | 900.00",
            "01/04/2014 | 1000.00 | 1000.00"
        );
    }
}
