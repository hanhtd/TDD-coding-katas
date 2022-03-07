package org.hanhtrd.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class StringCalculator {

    public static final String COMMA_DELIMITER = ",";
    public static final String NEW_LINE_DELIMITER = "\n";
    public static final List<String> INVALID_PARTS = List.of(
        ",\n",
        "\n,",
        ",,",
        "\n\n"
    );

    public int add(String calculatorString) {
        validate(calculatorString);

        List<String> delimiterList = new ArrayList<>();
        delimiterList.add(COMMA_DELIMITER);
        delimiterList.add(NEW_LINE_DELIMITER);
        String numberAsString = calculatorString;

        if (calculatorString.startsWith("//[")) {
            //begin delimiter //[
            String newDelimiter = calculatorString.substring(3, calculatorString.lastIndexOf("]"));
            delimiterList.addAll(asList(newDelimiter.split(Pattern.quote("]["))));

            numberAsString = calculatorString.substring(calculatorString.lastIndexOf("]") + 2);
            //end delimiter ]\n
        } else if (calculatorString.startsWith("//")) {
            //begin delimiter //
            String newDelimiter = calculatorString.substring(2, 3);
            delimiterList.add(newDelimiter);
            numberAsString = calculatorString.substring(4);
            //end delimiter \n
        }
        if (numberAsString.isEmpty()) {
            return 0;
        }

        List<String> numberItems = asList(numberAsString);
        for (String additionalOne : delimiterList) {
            numberItems = parseByDelimiter(numberItems, additionalOne);
        }

        int sum = 0;
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String numberItem : numberItems) {
            int number = Integer.parseInt(numberItem);
            if (number < 0) {
                negativeNumbers.add(number);
            }
            if (number <= 1000) {
                sum += number;
            }
        }
        if (negativeNumbers.isEmpty()) {
            return sum;
        } else {
            throw new IllegalArgumentException("negatives not allowed: "  + negativeNumbers.stream().map(String::valueOf).collect(Collectors.joining(",")));
        }

    }

    private List<String> parseByDelimiter(List<String> strings, String delimiter) {
        List<String> result = new ArrayList<>();
        for (String string : strings) {
            String[] items = string.split(Pattern.quote(delimiter));
            result.addAll(asList(items));
        }
        return result;
    }

    private void validate(String numbersAsString) {
        if (INVALID_PARTS.stream().anyMatch(numbersAsString::contains)) {
            throw new IllegalArgumentException("Input value is invalid");
        }
    }
}
