package tech.timaert.cluno.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tech.timaert.cluno.Engine;

import static org.junit.Assert.assertEquals;

public class EngineTest {
    private Engine engine;
    private final String TESTPLAYER1 = "Mark";
    private final String TESTPLAYER2 = "Fred";

    @Before
    public void setUp() {
        engine = new Engine();
    }

    @After
    public void breakDown() {
        engine = null;
    }

    @Test
    public void playCard() {
        engine.addPlayer(TESTPLAYER1);
        engine.addPlayer(TESTPLAYER2);
        engine.startGame();
        engine.currentPlayerPlayCard(3);
        assertEquals(6, engine.getCurrentPlayer().getHandSize());
        assertEquals(1, engine.getDiscardPileSize());
    }
}