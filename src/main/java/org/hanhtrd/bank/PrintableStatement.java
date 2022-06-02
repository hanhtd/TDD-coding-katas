package org.hanhtrd.bank;

public class PrintableStatement {

    private String _date;
    private int _amount;
    private int _runningBalance;

    public PrintableStatement(String date, int amount, int runningBalance) {
        _date = date;
        _amount = amount;
        _runningBalance = runningBalance;
    }
}
