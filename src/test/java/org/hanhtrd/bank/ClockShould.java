package org.hanhtrd.bank;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class ClockShould {

    @Test
    public void
    return_now_as_formatted_String() {
        Clock clock = new TestableClock();

        assertThat(clock.todayAsString()).isEqualTo("05/05/2021");
    }

    static class TestableClock extends Clock {

        @Override
        LocalDate now() {
            return LocalDate.of(2021, 5, 5);
        }
    }
}