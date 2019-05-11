package com.example.beerservice;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KillSwitchControllerTest {

    private KillSwitchController killSwitchController;

    @Before
    public void setup() {
        killSwitchController = new KillSwitchController();
    }

    @Test
    public void testFillMap() {
        assertThat(killSwitchController.fillUpMemory(100)).contains("Successfully created 100");
    }

    @Test
    public void testExitAbruptly() {
        assertThat(killSwitchController.exitAbruptly()).isEqualTo("Killed the application.");
    }

}
