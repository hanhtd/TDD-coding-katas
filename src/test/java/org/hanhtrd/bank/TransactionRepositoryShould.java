package org.hanhtrd.bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionRepositoryShould {

    @Mock
    private Clock clock;

    @Test public void
    save_deposit_transaction() {
        TransactionRepository repository = new TransactionRepository(clock);
        when(clock.todayAsString()).thenReturn("01/04/2014");

        repository.deposit(1_000);

        Transaction transaction = new Transaction("01/04/2014", 1_000);
        assertThat(repository.all()).containsExactly(transaction);
    }

    @Test public void
    save_withdrawal_transaction() {
        TransactionRepository repository = new TransactionRepository(clock);
        when(clock.todayAsString()).thenReturn("02/04/2014");

        repository.withdrawal(100);

        Transaction transaction = new Transaction("02/04/2014", -100);
        assertThat(repository.all()).containsExactly(transaction);
    }

}