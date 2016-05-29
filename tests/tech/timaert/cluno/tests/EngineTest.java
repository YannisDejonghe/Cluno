package tech.timaert.cluno.tests;

import org.junit.Before;
import org.junit.Test;
import tech.timaert.cluno.Engine;
import tech.timaert.cluno.Player;

import static org.junit.Assert.assertEquals;

public class EngineTest {
    private Engine engine;
    private Player playerOne;
    private Player playerTwo;

    @Before
    public void setUp() throws Exception {
        engine = new Engine();
        playerOne = new Player("Mark");
        playerTwo = new Player("George");
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
}