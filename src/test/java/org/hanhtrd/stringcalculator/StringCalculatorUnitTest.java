package org.hanhtrd.stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorUnitTest {

    @ParameterizedTest(name = "add('{0}')={1}")
    @MethodSource("testData")
    public void test_that_string_calculator_return_expected_total_value(String numbersAsString, int expectedSum) {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.add(numbersAsString)).isEqualTo(expectedSum);
    }

    @ParameterizedTest(name = "{0} is invalid input")
    @MethodSource("erroneousData")
    public void test_that_exception_thrown_for_invalid_input(String invalidInput) {
        StringCalculator calculator = new StringCalculator();

        assertThatThrownBy(() -> calculator.add(invalidInput))
            .isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessage("Input value is invalid");
    }

    @ParameterizedTest(name = "add_with_delimiter_declaration('{0}')={1}")
    @MethodSource("testDataWithDelimiterDeclaration")
    public void test_that_string_calculator_support_different_delimiters(String numbersAsString, int expectedSum) {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.add(numbersAsString)).isEqualTo(expectedSum);
    }

    private static Object testDataWithDelimiterDeclaration() {
        return new Object[][]{
            /*"//[delimiter]\n[numbers…]"*/
            { "//;\n1;2",       3 },
            { "//;\n",          0 },
            { "//;\n1",         1 },
            { "//;\n1;4\n5",    10},
            { "//;\n1;4,5",     10},
        };
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-1,-3;negatives not allowed: -1,-3",
            "-2;negatives not allowed: -2",
    }, delimiter = ';')
    public void test_that_string_calculator_will_throw_negatives_not_allowed2(String numbers, String expected) {
        StringCalculator calculator = new StringCalculator();

        assertThatThrownBy(() -> calculator.add(numbers)).isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessage(expected);
    }

    @Test
    public void test_that_string_calculator_support_any_length_of_delimiter() {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.add("//[***]\n1***2")).isEqualTo(3);
        assertThat(calculator.add("//[**]\n1**2")).isEqualTo(3);
        assertThat(calculator.add("//[*]\n1*2")).isEqualTo(3);
        assertThat(calculator.add("//[***]\n1***2***3")).isEqualTo(6);
    }

    @Test
    public void test_that_string_calculator_supports_mutiple_delimiter_of_any_length() {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.add("//[*][%]\n1*2%3")).isEqualTo(6);
    }

    private static List<String> erroneousData() {
        return List.of(
                "1,\n",
                "1\n,",
                "\n,1",
                ",\n1",
                "1,,",
                "1\n\n\n"
        );
    }

    private static Object testData() {
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
//    @Test
//    public void string_splitting_test() {
//        assertThat("\n".split("\n")).isEmpty();
//        assertThat("abc".split("abc")).isEmpty();
//    }
}
