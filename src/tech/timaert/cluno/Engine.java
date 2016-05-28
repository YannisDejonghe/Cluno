package tech.timaert.cluno;

import java.util.HashSet;
import java.util.Set;

public class Engine {
    private Pile drawPile;
    private Pile discardPile;
    private Set<Player> players;

    public Engine() {
        drawPile = new Pile();
        discardPile = new Pile();
        players = new HashSet<>();
        fillDrawPile();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public int getPlayerAmount() {
        return players.size();
    }

    public int getDrawPileSize() {
        return drawPile.getCardAmount();
    }

    private void fillDrawPile() {
        for(Color color: Color.values()) {
            addCardsOfColor(color);
        }

        drawPile.addCard(new Card(Type.WILD), 4);
        drawPile.addCard(new Card(Type.WILD_DRAW_FOUR), 4);
    }

    private void addCardsOfColor(Color color) {
        fillNormalCards(color);
        drawPile.addCard(new Card(color, Type.REVERSE), 2);
        drawPile.addCard(new Card(color, Type.SKIP), 2);
        drawPile.addCard(new Card(color, Type.DRAW_TWO), 2);
    }

    private void fillNormalCards(Color color) {
        drawPile.addCard(new Card(color, Type.NORMAL, 0), 1);

        for(int value = 1; value < 10; value++) {
            drawPile.addCard(new Card(color, Type.NORMAL, value), 2);
        }
    }
}
