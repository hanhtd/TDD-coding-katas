package org.hanhtrd.bank;

import java.util.Objects;

public class PrintableStatement {

    private String _date;
    private int _amount;
    private int _runningBalance;

    public PrintableStatement(String date, int amount, int runningBalance) {
        _date = date;
        _amount = amount;
        _runningBalance = runningBalance;
    }

    public int getRunningBalance() {
        return _runningBalance;
    }

    public String getDate() {
        return _date;
    }

    public int getAmount() {
        return _amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof PrintableStatement)) {return false;}
        PrintableStatement that = (PrintableStatement) o;
        return getAmount() == that.getAmount() && getRunningBalance() == that.getRunningBalance() && getDate().equals(that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getAmount(), getRunningBalance());
    }
}
