package org.hanhtrd.bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

// Unit test
@ExtendWith(MockitoExtension.class)
public class AccountShould {

    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private StatementPrinter statementPrinter;

    @Test public void
    store_deposit_transaction() {
        Account account = new Account(transactionRepository, statementPrinter);

        account.deposit(1_000);

        verify(transactionRepository).deposit(1_000);
    }

    @Test public void
    store_withdrawal_transaction() {
        Account account = new Account(transactionRepository, statementPrinter);

        account.withdrawal(500);

        verify(transactionRepository).withdrawal(500);
    }

    @Test public void
    print_transaction_statement() {
        Account account = new Account(transactionRepository, statementPrinter);
        List<Transaction> transactions = asList(
            new Transaction("02/04/2014", -100),
            new Transaction("10/04/2014", 500)
        );
        when(transactionRepository.all()).thenReturn(transactions);

        account.printStatement();

        verify(statementPrinter).print(transactions);
    }
}