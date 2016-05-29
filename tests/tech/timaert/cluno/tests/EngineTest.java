package tech.timaert.cluno.tests;

import org.junit.Before;
import org.junit.Test;
import tech.timaert.cluno.Engine;

import static org.junit.Assert.assertEquals;

public class EngineTest {
    private Engine engine;
    private String playerOne;
    private String playerTwo;

    @Before
    public void setUp() throws Exception {
        engine = new Engine();
        playerOne = "Mark";
        playerTwo = "George";
    }

    @Test
    public void testDrawPileSizeAfterInitialization() {
        assertEquals(108, engine.getDrawPileSize());
    }

    @Test
    public void testGameSetup() {
        engine.addPlayer(playerOne);
        engine.addPlayer(playerTwo);
        engine.startGame();
        assertEquals(2, engine.getPlayerAmount());
        assertEquals(7, engine.getCurrentPlayer().getHand().size());
    }

    @Test
    public void testCardPlay() {
        engine.addPlayer(playerOne);
        engine.addPlayer(playerTwo);
        engine.startGame();
        engine.getCurrentPlayer().playCard(2);
        assertEquals(1, engine.getDiscardPileSize());
        assertEquals(6, engine.getCurrentPlayer().getHand().size());
    }
}