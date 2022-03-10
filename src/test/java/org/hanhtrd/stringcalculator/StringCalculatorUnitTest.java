package org.hanhtrd.stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorUnitTest {

    @ParameterizedTest(name = "add(`{0}`) = {1}")
    @MethodSource({
        "dataWithoutDelimiterDeclaration",
        "dataWithDelimiterDeclaration",
        "dataMultipleDelimiterAnyLength",
        "dataADelimiterOfAnyLength"
    })
    public void test_that_string_calculator_return_expected_total_value(String numbersAsString, int expectedSum) {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.add(numbersAsString)).isEqualTo(expectedSum);
    }

    @ParameterizedTest(name = "`{0}` : {1}")
    @MethodSource({"erroneousData", "dataNegativesNotAllow"})
    public void test_that_exception_thrown_for_invalid_input(String invalidInput, String message) {
        StringCalculator calculator = new StringCalculator();

        assertThatThrownBy(() -> calculator.add(invalidInput))
            .isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    private static Object[][] dataNegativesNotAllow() {
        return new Object[][] {
            { "-1,-3", "negatives not allowed: -1,-3"},
            {  "-2", "negatives not allowed: -2" }
        };
    }

    private static Object[][] dataWithDelimiterDeclaration() {
        return new Object[][]{
            /*"//[delimiter]\n[numbers…]"*/
            { "//;\n1;2",       3 },
            { "//;\n",          0 },
            { "//;\n1",         1 },
            { "//;\n1;4\n5",    10},
            { "//;\n1;4,5",     10},
        };
    }

    private static Object[][] dataADelimiterOfAnyLength() {
        return new Object[][] {
            {"//[***]\n1***2",                     3},
            {"//[**]\n1**2",                       3},
            {"//[*]\n1*2",                         3},
            {"//[***]\n1***2***3",                 6}
        };
    }

    private static Object[][] dataMultipleDelimiterAnyLength() {
        return new Object[][] {
            {"//[*][%]\n1*2%3",                     6},
            {"//[*******][%%%]\n1*******2%%%3",     6}
        };
    }

    private static Object[][] erroneousData() {
        return new Object[][] {
            {"1,\n", "Input value is invalid"},
            {"1\n,", "Input value is invalid"},
            {"\n,1", "Input value is invalid"},
            {",\n1", "Input value is invalid"},
            {"1,,", "Input value is invalid"},
            {"1\n\n\n", "Input value is invalid"},
        };
    }

    private static Object[][] dataWithoutDelimiterDeclaration() {
        return new Object[][]{
                { "", 0 },

                { "1", 1 },

                { "10", 10 },
                { "21", 21 },

                { "1,2", 3 },
                { "6,4", 10 },
                { "1,4,5", 10 },

                { "1\n4\n5", 10 },
                { "1\n4\n5\n7", 17 },

                { "1,4\n5", 10 },
                { "1\n4,5", 10 },

                // number > 1_000 will be ignored
                { "1000,5", 1_005 },
                { "1001,5", 5 },
        };
    }
}
