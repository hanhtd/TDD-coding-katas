package org.hanhtrd.romannumerals;

public class RomanNumeralGeneratorSecondTime {

    public static String romanFor(int decimalNo) {
        StringBuilder romanNoBuilder = new StringBuilder();

        for (RomanDecimalNumeralMapping numeralMapping : RomanDecimalNumeralMapping.values()) {
            while (decimalNo >= numeralMapping._decimalNo) {
                romanNoBuilder.append(numeralMapping._romanNo);
                decimalNo -= numeralMapping._decimalNo;
            }
        }
        return romanNoBuilder.toString();
    }

    enum RomanDecimalNumeralMapping {
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

        final String _romanNo;
        final int _decimalNo;

        RomanDecimalNumeralMapping(String romanNo, int decimalNo) {
            _romanNo = romanNo;
            _decimalNo = decimalNo;
        }
    }
}
