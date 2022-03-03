package org.hanhtrd.stringcalculator;

public class StringCalculator {

    public static final String PARAMETER_SEPARATOR = ",";

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        if (!numbers.contains(PARAMETER_SEPARATOR)) {
            return Integer.parseInt(numbers);
        }

        String[] parameters = numbers.split(PARAMETER_SEPARATOR);
        int sum = 0;
        for (String parameter : parameters) {
            sum += Integer.parseInt(parameter);
        }
        return sum;
    }
}
