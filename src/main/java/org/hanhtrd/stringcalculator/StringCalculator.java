package org.hanhtrd.stringcalculator;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class StringCalculator {

    public static final String COMMA_PARAMETER_SEPARATOR = ",";
    public static final String NEW_LINE_PARAMETER_SEPARATOR = "\n";
    public static final List<String> INVALID_PARTS = List.of(
        ",\n",
        "\n,",
        ",,",
        "\n\n"
    );

    public int add(String numbersAsString) {
        validate(numbersAsString);

        if (numbersAsString.isEmpty()) {
            return 0;
        }

        String[] firstSpitedItemArr = numbersAsString.split(COMMA_PARAMETER_SEPARATOR);
        List<String> secondSpitedItemList = new ArrayList<>();
        for (String parameter : firstSpitedItemArr) {
            String[] numberItems = parameter.split(NEW_LINE_PARAMETER_SEPARATOR);
            secondSpitedItemList.addAll(asList(numberItems));
        }

        int sum = 0;
        for (String numberItem : secondSpitedItemList) {
            sum += Integer.parseInt(numberItem);
        }
        return sum;
    }

    private void validate(String numbersAsString) {
        if (INVALID_PARTS.stream().anyMatch(numbersAsString::contains)) {
            throw new IllegalArgumentException("Input value is invalid");
        }
    }
}
