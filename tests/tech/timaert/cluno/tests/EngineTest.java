package tech.timaert.cluno.tests;

import org.junit.Before;
import org.junit.Test;
import tech.timaert.cluno.Engine;

import static org.junit.Assert.assertEquals;

public class EngineTest {
    private Engine engine;

    @Before
    public void setUp() throws Exception {
        engine = new Engine();
    }

    @Test
    public void testDrawPileSizeAfterInitialization() {
        assertEquals(108, engine.getDrawPileSize());
    }
}