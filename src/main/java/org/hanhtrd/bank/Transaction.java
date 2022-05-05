package org.hanhtrd.bank;

import java.util.Objects;

public class Transaction {
    private String _date;
    private int _amount;

    public Transaction(String date, int amount) {
        _date = date;
        _amount = amount;
    }

    public String getDate() {
        return _date;
    }

    public void setDate(String date) {
        _date = date;
    }

    public int getAmount() {
        return _amount;
    }

    public void setAmount(int amount) {
        _amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Transaction that = (Transaction) o;
        return _amount == that._amount && Objects.equals(_date, that._date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_date, _amount);
    }
}
