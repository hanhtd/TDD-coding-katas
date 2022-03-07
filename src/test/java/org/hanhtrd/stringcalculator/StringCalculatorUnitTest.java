package org.hanhtrd.stringcalculator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class StringCalculatorUnitTest {

    @Test
    @Parameters(method = "testData")
    @TestCaseName("add('{0}')={1}")
    public void test_that_string_calculator_return_expected_total_value(String numbersAsString, int expectedSum) {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.add(numbersAsString)).isEqualTo(expectedSum);
    }

    private Object testData() {
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

    @Test
    @Parameters(method = "erroneousData")
    @TestCaseName("{0} is invalid input")
    public void test_that_exception_thrown_for_invalid_input(String invalidInput) {
        StringCalculator calculator = new StringCalculator();

        assertThatThrownBy(() -> calculator.add(invalidInput))
            .isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessage("Input value is invalid");
    }

    private List<String> erroneousData() {
        return List.of(
            "1,\n",
            "1\n,",
            "\n,1",
            ",\n1",
            "1,,",
            "1\n\n\n"
        );
    }

    @Test
    @Parameters(method = "testDataWithDelimiterDeclaration")
    @TestCaseName("add_with_delimiter_declaration('{0}')={1}")
    public void test_that_string_calculator_support_different_delimiters(String numbersAsString, int expectedSum) {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.add(numbersAsString)).isEqualTo(expectedSum);
    }

    private Object testDataWithDelimiterDeclaration() {
        return new Object[][]{
            /*"//[delimiter]\n[numbers…]"*/
            { "//;\n1;2",       3 },
            { "//;\n",          0 },
            { "//;\n1",         1 },
            { "//;\n1;4\n5",    10},
            { "//;\n1;4,5",     10},
        };
    }

    @Test
    public void test_that_string_calculator_will_throw_negatives_not_allowed2() {
        //TODO refactor to unit 5 and parameterize this test case
        StringCalculator calculator = new StringCalculator();

        assertThatThrownBy(() -> calculator.add("-1,-3")).isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessage("negatives not allowed: -1,-3");
    }

    @Test
    public void test_that_string_calculator_support_any_length_of_delimiter() {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.add("//[***]\n1***2")).isEqualTo(3);
        assertThat(calculator.add("//[**]\n1**2")).isEqualTo(3);
        assertThat(calculator.add("//[*]\n1*2")).isEqualTo(3);
        assertThat(calculator.add("//[***]\n1***2***3")).isEqualTo(6);
    }
//    @Test
//    public void string_splitting_test() {
//        assertThat("\n".split("\n")).isEmpty();
//        assertThat("abc".split("abc")).isEmpty();
//    }
}
