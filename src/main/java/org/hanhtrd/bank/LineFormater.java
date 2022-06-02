package org.hanhtrd.bank;

public class LineFormater {

    public String format(PrintableStatement printableStatement) {
        return printableStatement.getDate() + " | "
            + printableStatement.getAmount() + ".00 | "
            + printableStatement.getRunningBalance() + ".00";
    }
}
