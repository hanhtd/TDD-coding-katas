package org.hanhtrd.christmaslights;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChristmasLightSystemShould {

    @Test
    public void turn_on_an_expected_light_number_for_each_turn_on_instruction() {
        ChristmasLightSystem lightSystem = new ChristmasLightSystem();

        assertThat(
            lightSystem.turnOn(887, 9, 959, 629)
        ).isEqualTo(45_333);
        assertThat(
            lightSystem.turnOn(454, 398, 844, 448)
        ).isEqualTo(19_941);
        assertThat(
            lightSystem.turnOn(1, 2, 1, 2)
        ).isEqualTo(1);
    }

    @Test
    public void turn_off_an_expected_light_number_for_each_turn_off_instruction() {
        ChristmasLightSystem lightSystem = new ChristmasLightSystem();

        assertThat(
            lightSystem.turnOff(1, 2, 3, 8)
        ).isEqualTo(21);
        assertThat(
            lightSystem.turnOff(539, 243, 559, 965)
        ).isEqualTo(15_183);
    }

    @Test
    public void turn_on_an_expected_light_number_for_each_toggle_instruction() {
        ChristmasLightSystem lightSystem = new ChristmasLightSystem();

        assertThat(lightSystem.toggle(1, 2, 3, 8)).isEqualTo(21);
    }
}
