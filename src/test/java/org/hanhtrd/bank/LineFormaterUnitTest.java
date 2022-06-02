package org.hanhtrd.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LineFormaterUnitTest {

    @Test
    public void format() {
        LineFormater lineFormater = new LineFormater();

        String formatted = lineFormater.format(new PrintableStatement("01/04/2014", 1000, 1000));

        assertThat(formatted).isEqualTo("01/04/2014 | 1000.00 | 1000.00");
    }
}