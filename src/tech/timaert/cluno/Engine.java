package tech.timaert.cluno;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Engine {
    private Pile drawPile;
    private Pile discardPile;
    private Set<Player> players;
    private Player currentPlayer;
    private boolean winnerFound;

    public Engine() {
        drawPile = new Pile();
        discardPile = new Pile();
        players = new HashSet<>();
        fillDrawPile();
    }

    public void startGame() {
        if(players.size() > 1) {
            dealStartingHands();
            currentPlayer = selectStartingPlayer();
            winnerFound = false;
            startGameLoop();
        }
    }

    private void startGameLoop(){
        while(!winnerFound) {
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    private void dealStartingHands() {
        Iterator<Player> playerIterator = players.iterator();
        playerIterator.forEachRemaining(player -> drawPile.dealCard(player, 7));
    }

    private Player selectStartingPlayer() {
        Player player = null;
        Random random = new Random();
        Iterator<Player> playerIterator = players.iterator();

        for(int i = 0; i < random.nextInt(players.size()); i++){
            player = playerIterator.next();
        }

        return player;
    }

    public void addPlayer(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
    }

    public int getPlayerAmount() {
        return players.size();
    }

    public int getDrawPileSize() {
        return drawPile.getCardAmount();
    }

    public int getDiscardPileSize() {
        return discardPile.getCardAmount();
    }

    private void fillDrawPile() {
        for(Color color: Color.values()) {
            addCardsOfColor(color);
        }

        drawPile.updateCard(new Card(Type.WILD), 4);
        drawPile.updateCard(new Card(Type.WILD_DRAW_FOUR), 4);
    }

    private void addCardsOfColor(Color color) {
        fillNormalCards(color);
        drawPile.updateCard(new Card(color, Type.REVERSE), 2);
        drawPile.updateCard(new Card(color, Type.SKIP), 2);
        drawPile.updateCard(new Card(color, Type.DRAW_TWO), 2);
    }

    private void fillNormalCards(Color color) {
        drawPile.updateCard(new Card(color, Type.NORMAL, 0), 1);

        for(int value = 1; value < 10; value++) {
            drawPile.updateCard(new Card(color, Type.NORMAL, value), 2);
        }
    }
}
