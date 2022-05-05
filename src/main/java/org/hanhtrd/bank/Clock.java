package org.hanhtrd.bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {

    public String todayAsString() {
        return now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    LocalDate now() {
        return LocalDate.now();
    }
}
