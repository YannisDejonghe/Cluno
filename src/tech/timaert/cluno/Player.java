package tech.timaert.cluno;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private boolean calledUno;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
        calledUno = false;
    }

    public void drawCard(Card card) {
        hand.add(card);
    }

    public boolean calledUno() {
        return calledUno;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getHandSize() {
        return hand.size();
    }

    public void callUno() {
        calledUno = true;
    }

    public Card playCard(int cardIndex) {
        Card cardToPlay = hand.get(cardIndex);
        hand.remove(cardIndex);
        return cardToPlay;
    }
}
