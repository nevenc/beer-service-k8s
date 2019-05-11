package com.example.beerservice;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KillSwitchTest {

    private KillSwitch killSwitch;

    @Before
    public void setup() {
        killSwitch = new KillSwitch();
    }

    @Test
    public void testFillMap() {
        assertThat(killSwitch.fillUpMemory(100)).contains("Successfully created 100");
    }

    @Test
    public void testExitAbruptly() {
        assertThat(killSwitch.exitAbruptly()).isEqualTo("Killed the application.");
    }

}
