package org.hanhtrd.stringcalculator;

import java.util.ArrayList;
import java.util.List;

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
        if (calculatorString.startsWith("//")) {
            newDelimiter = calculatorString.substring(2, 3);
            numberAsString = calculatorString.substring(4);
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
        for (String numberItem :secondSpitedItemList) {
            sum += Integer.parseInt(numberItem);
        }
        return sum;
    }

    private List<String> parseByDelimiter(List<String> strings, String delimiter) {
        List<String> result = new ArrayList<>();
        for (String string : strings) {
            String[] items = string.split(delimiter);
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
