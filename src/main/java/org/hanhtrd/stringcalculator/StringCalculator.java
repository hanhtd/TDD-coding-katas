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

        String newDelimiter = null;
        String numberAsString = calculatorString;

        if (calculatorString.startsWith("//[")) {
            //begin delimiter //[
            newDelimiter = calculatorString.substring(3, calculatorString.indexOf("]"));
            numberAsString = calculatorString.substring(calculatorString.indexOf("]") + 2);
            //end delimiter ]\n
        } else if (calculatorString.startsWith("//")) {
            //begin delimiter //
            newDelimiter = calculatorString.substring(2, 3);
            numberAsString = calculatorString.substring(4);
            //end delimiter \n
        }
        if (numberAsString.isEmpty()) {
            return 0;
        }

        List<String> firstSpitedItemArr = parseByDelimiter(asList(numberAsString), COMMA_DELIMITER);
        List<String> secondSpitedItemList = parseByDelimiter(firstSpitedItemArr, NEW_LINE_DELIMITER);
        if (newDelimiter != null) {
            secondSpitedItemList = parseByDelimiter(secondSpitedItemList, newDelimiter);
        }

        int sum = 0;
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String numberItem : secondSpitedItemList) {
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
