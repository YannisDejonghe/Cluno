package tech.timaert.cluno;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public void drawCard(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }
}
