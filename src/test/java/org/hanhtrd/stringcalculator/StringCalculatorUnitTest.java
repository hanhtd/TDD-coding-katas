package org.hanhtrd.stringcalculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class StringCalculatorUnitTest {

    @Parameters(name = "add({0})={1}")
    public static Collection<Object[]> data() {
        return List.of(
            new Object[][]{
                { "",           0 },
                { "1",          1 },
                { "10",         10 },
                { "21",         21 },
                { "1,2",        3 },
                { "6,4",        10 },
                { "1,4,5",      10 }
            }
        );
    }

    @Parameter(0)
    public String _numbersAsString;

    @Parameter(1)
    public int _expectedSum;

    @Test
    public void test_that_string_calculator_works_as_expected() {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.add(_numbersAsString)).isEqualTo(_expectedSum);
    }
}
