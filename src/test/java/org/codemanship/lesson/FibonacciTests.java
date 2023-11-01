package org.codemanship.lesson;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciTests {

    @Test
    void firstNumberInSequenceIsZero() {
        assertThat(new Fibonacci().getNumber(0)).isEqualTo(0);
    }

}
