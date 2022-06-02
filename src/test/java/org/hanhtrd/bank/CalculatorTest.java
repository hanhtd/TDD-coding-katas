package org.hanhtrd.bank;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void calculate_running_balance_for_one_transaction() {
        Calculator calculator = new Calculator();

        List<PrintableStatement> results = calculator.calculate(List.of(
           new Transaction("01/04/2014", 1_000)
        ));

        assertThat(results).containsExactly(
            new PrintableStatement("01/04/2014", 1_000, 1_000)
        );
    }
}