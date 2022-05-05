package org.hanhtrd.bank;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class TransactionRepository {
    private List<Transaction> _transactions = new ArrayList<>();
    private Clock _clock;

    public TransactionRepository(Clock clock) {
        _clock = clock;
    }

    public void deposit(int amount) {
        Transaction transaction = new Transaction(_clock.todayAsString(), amount);
        _transactions.add(transaction);
    }

    public List<Transaction> all() {
        return unmodifiableList(_transactions);
    }

    public void withdrawal(int amount) {
        deposit(-amount);
    }
}
