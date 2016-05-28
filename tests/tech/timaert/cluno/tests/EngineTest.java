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
    private Player playerThree;

    @Before
    public void setUp() throws Exception {
        engine = new Engine();
        playerOne = new Player("Mark");
        playerTwo = new Player("George");
        playerThree = new Player("Frank");
    }

    @Test
    public void testDrawPileSizeAfterInitialization() {
        assertEquals(108, engine.getDrawPileSize());
    }

    @Test
    public void testPlayerAdding() {
        engine.addPlayer(playerOne);
        engine.addPlayer(playerTwo);
        engine.addPlayer(playerThree);
        assertEquals(3, engine.getPlayerAmount());
    }
}