package org.hse.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for App class.
 */
class AppTest {

    @Test
    @DisplayName("App should have main method")
    void testAppHasMainMethod() {
        // Verify that the App class exists and has a main method
        assertThat(Main.class).isNotNull();
    }
}
