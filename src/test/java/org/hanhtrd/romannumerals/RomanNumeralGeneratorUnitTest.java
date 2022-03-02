package org.hanhtrd.romannumerals;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

// TODO: ThinK about how many, which type of test did he use.
public class RomanNumeralGeneratorUnitTest {

    @Test
    public void test_RomanNumeralGeneratorSecondTime_should() {
        assertThat(RomanNumeralGeneratorSecondTime.romanFor(1)).isEqualTo("I");
        assertThat(RomanNumeralGeneratorSecondTime.romanFor(2)).isEqualTo("II");
        assertThat(RomanNumeralGeneratorSecondTime.romanFor(3)).isEqualTo("III");
        assertThat(RomanNumeralGeneratorSecondTime.romanFor(5)).isEqualTo("V");
        assertThat(RomanNumeralGeneratorSecondTime.romanFor(7)).isEqualTo("VII");
        assertThat(RomanNumeralGeneratorSecondTime.romanFor(8)).isEqualTo("VIII");
        assertThat(RomanNumeralGeneratorSecondTime.romanFor(10)).isEqualTo("X");
        assertThat(RomanNumeralGeneratorSecondTime.romanFor(13)).isEqualTo("XIII");
        assertThat(RomanNumeralGeneratorSecondTime.romanFor(18)).isEqualTo("XVIII");
        assertThat(RomanNumeralGeneratorSecondTime.romanFor(30)).isEqualTo("XXX");
        assertThat(RomanNumeralGeneratorSecondTime.romanFor(4)).isEqualTo("IV");
        assertThat(RomanNumeralGeneratorSecondTime.romanFor(9)).isEqualTo("IX");

        assertThat(RomanNumeralGeneratorSecondTime.romanFor(3567)).isEqualTo("MMMDLXVII");
        assertThat(RomanNumeralGeneratorSecondTime.romanFor(2249)).isEqualTo("MMCCXLIX");
    }
}
