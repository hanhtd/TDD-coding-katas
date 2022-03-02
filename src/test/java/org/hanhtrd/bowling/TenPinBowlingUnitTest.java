package org.hanhtrd.bowling;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TenPinBowlingUnitTest {
    // TODO
    // [OK] 1. Write test list first.
    // 12|34|52|31|11|44|11|21|31|41                =   45
    // --|--|--|--|--|--|--|--|--|--                =   0
    // 2-|4-|3-|5-|6-|7-|1-|2-|3-|4-                =   37
    // -2|-4|-3|-5|-6|-7|-1|-2|-3|-4                =   37
    // -2|-4|-3|-5|6-|7-|4-|2-|4-|5-                =   42
    // 2/|4/|3/|5/|6/|7/|4/|2/|4/|51                =   136
    // 2/|4/|3/|5/|6/|7/|4/|2/|4/|5/1               =   146
    // 2/|4/|3/|5/|-/|7/|4/|2/|-/|5/-               =   135
    // 2/|4/|3/|5/|6/|7/|4/|2/|4/|5/X               =   155
    // X |X |X |X |X |X |X |X |X |X12               =
    // X |X |X |X |X |X |X |X |X |X1-               =
    // X |X |X |X |X |X |X |X |X |X1X               =
    // X |X |X |X |X |X |X |X |X |XXX               =
    // X |X |X |X |X |X |X |X |X |X55               =
    // X |12|X |X |X |X |34|X |56|X12               =
    // X |--|X |X |--|X |X |X |--|X12               =
    // X |4/|X |X |6/|X |X |X |1/|X12               =
    // X |4/|X |X |6/|X |X |-7|1/|-12               =
    // 3 random tests for make sure design that is good enough.
    // [WIP] 2. Re-order test cases.

    // 3. Start with first test.
    // 4. Keep rhythm of TDD + baby step
    // 5. Write assertion first then back to test then arrange section in each test case.
    @Test
    public void TenPinBowlingShould() {
        assertThat(TenPinBowling.calculateScore("12345231114411213141")).isEqualTo(45);
        assertThat(TenPinBowling.calculateScore("12345231114411213163")).isEqualTo(49);
        assertThat(TenPinBowling.calculateScore("--------------------")).isEqualTo(0);
    }
}
