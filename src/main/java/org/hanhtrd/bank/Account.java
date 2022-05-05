package org.hanhtrd.bank;

import java.util.List;

public class Account {

    private TransactionRepository _transactionRepository;
    private final StatementPrinter _statementPrinter;

    public Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
        _transactionRepository = transactionRepository;
        _statementPrinter = statementPrinter;
    }

    public void printStatement() {
        List<Transaction> transactions = _transactionRepository.all();
        _statementPrinter.print(transactions);
        //_console.print("DATE | AMOUNT | BALANCE");
        // sort
        // translate into string
        // loop and pass to _console.
    }

    public void deposit(int amount) {
        _transactionRepository.deposit(amount);
    }

    public void withdrawal(int amount) {
        _transactionRepository.withdrawal(amount);
    }
}
