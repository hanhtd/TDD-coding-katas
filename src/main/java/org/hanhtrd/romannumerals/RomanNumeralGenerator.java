package org.hanhtrd.romannumerals;

public class RomanNumeralGenerator {

    public static String romanFor(int decimalNo) {
        String roman = "";
        for (RomanToDecimal romanToDecimal : RomanToDecimal.values()) {
            while (decimalNo >= romanToDecimal._decimal) {
                roman += romanToDecimal._roman;
                decimalNo -= romanToDecimal._decimal;
            }
        }
        return roman;
    }

    enum RomanToDecimal {
        ONE_THOUSAND("M", 1_000),
        NINE_HUNDREDS("CM", 900),
        FIVE_HUNDREDS("D", 500),
        FOUR_HUNDREDS("CD", 400),
        ONE_HUNDRED("C", 100),
        NINETY("XC", 90),
        FIFTY("L", 50),
        FORTY("XL", 40),
        TEN("X", 10),
        NINE("IX", 9),
        FIVE("V", 5),
        FOUR("IV", 4),
        ONE("I", 1);

        private final String _roman;
        private final int _decimal;

        RomanToDecimal(String roman, int decimal) {
            _roman = roman;
            _decimal = decimal;
        }
    }
}
