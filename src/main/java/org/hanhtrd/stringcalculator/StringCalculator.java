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
        String numberListAsString = getNumberListAsString(calculatorString);
        validate(numberListAsString);
        if (numberListAsString.isEmpty()) {
            return 0;
        }
        List<String> delimiterList = getDelimiterList(calculatorString);
        List<String> stringNumbers = parseByDelimiters(numberListAsString, delimiterList);
        return calculateSumOfStringNumbers(stringNumbers);
    }

    private List<String> parseByDelimiters(String numberListAsString, List<String> delimiterList) {
        // TODO: Refactoring later
        List<String> stringNumbers = asList(numberListAsString);
        for (String delimiter : delimiterList) {
            List<String> result = new ArrayList<>();
            for (String string : stringNumbers) {
                String[] items = string.split(Pattern.quote(delimiter));
                result.addAll(asList(items));
            }
            stringNumbers = result;
        }
        return stringNumbers;
    }

    private String getNumberListAsString(String calculatorString) {
        if (calculatorString.startsWith("//")) {
            // Separator between delimiter declaration and number list
            int indexOfSeparator = calculatorString.indexOf('\n');
            return calculatorString.substring(indexOfSeparator + 1);
        } else {
            return calculatorString;
        }
    }

    private void validate(String numbersAsString) {
        if (INVALID_PARTS.stream().anyMatch(numbersAsString::contains)) {
            throw new IllegalArgumentException("Input value is invalid");
        }
    }

    private List<String> getDelimiterList(String calculatorString) {
        List<String> delimiterList = new ArrayList<>();
        delimiterList.add(COMMA_DELIMITER);
        delimiterList.add(NEW_LINE_DELIMITER);

        if (calculatorString.startsWith("//[")) {
            String newDelimiter = calculatorString.substring(3, calculatorString.lastIndexOf(']'));
            delimiterList.addAll(asList(newDelimiter.split(Pattern.quote("]["))));
        } else if (calculatorString.startsWith("//")) {
            String newDelimiter = calculatorString.substring(2, 3);
            delimiterList.add(newDelimiter);
        }
        return delimiterList;
    }

    private int calculateSumOfStringNumbers(List<String> stringNumbers) {
        int sum = 0;
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String stringNumber : stringNumbers) {
            int number = Integer.parseInt(stringNumber);
            if (number < 0) {
                negativeNumbers.add(number);
            }
            if (number <= 1000) {
                sum += number;
            }
        }
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negativeNumbers.stream().map(String::valueOf).collect(Collectors.joining(",")));
        }

        return sum;
    }
}
