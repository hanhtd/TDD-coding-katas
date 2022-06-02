package org.hanhtrd.bank;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void calculate_running_balance_for_one_transaction() {
        Calculator calculator = new Calculator();

        Set<PrintableStatement> results = calculator.calculate(Set.of(
            new Transaction("01/04/2014", 1_000)
        ));

        assertThat(results).usingRecursiveFieldByFieldElementComparator().containsExactly(
            new PrintableStatement("01/04/2014", 1_000, 1_000)
        );
    }

    @Test
    void calculate_running_balance_for_multi_transaction() {
        Calculator calculator = new Calculator();

        Set<PrintableStatement> results = calculator.calculate(Set.of(
            new Transaction("01/04/2014", 100),
           new Transaction("02/04/2014", 200)
        ));

        assertThat(results).containsExactlyInAnyOrder(
            new PrintableStatement("01/04/2014", 100, 100),
            new PrintableStatement("02/04/2014", 200, 300)
        );
    }
}