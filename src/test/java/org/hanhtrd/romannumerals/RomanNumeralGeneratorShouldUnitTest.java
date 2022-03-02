package org.hanhtrd.romannumerals;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
//https://www.youtube.com/watch?v=iZjgj1S0FCY&t=244s
public class RomanNumeralGeneratorShouldUnitTest {

    @Test
    public void generate_a_roman_numeral_for_a_given_decimal_number() {
        assertThat(RomanNumeralGenerator.romanFor(1)).isEqualTo("I");
        assertThat(RomanNumeralGenerator.romanFor(2)).isEqualTo("II");
        assertThat(RomanNumeralGenerator.romanFor(3)).isEqualTo("III");
        assertThat(RomanNumeralGenerator.romanFor(4)).isEqualTo("IV");
        assertThat(RomanNumeralGenerator.romanFor(5)).isEqualTo("V");
        assertThat(RomanNumeralGenerator.romanFor(7)).isEqualTo("VII");
        assertThat(RomanNumeralGenerator.romanFor(9)).isEqualTo("IX");
        assertThat(RomanNumeralGenerator.romanFor(10)).isEqualTo("X");
        assertThat(RomanNumeralGenerator.romanFor(18)).isEqualTo("XVIII");
        assertThat(RomanNumeralGenerator.romanFor(30)).isEqualTo("XXX");

        assertThat(RomanNumeralGenerator.romanFor(1909)).isEqualTo("MCMIX");
        assertThat(RomanNumeralGenerator.romanFor(2687)).isEqualTo("MMDCLXXXVII");
        assertThat(RomanNumeralGenerator.romanFor(3499)).isEqualTo("MMMCDXCIX");
    }

}
