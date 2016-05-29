package tech.timaert.cluno;

import java.util.*;

public class Pile {
    private Map<Card, Integer> inventory;
    private int cardAmount;

    public Pile() {
        inventory = new HashMap<>();
        cardAmount = 0;
    }

    public void updateCard(Card card, int amount) {
        Integer newAmount;

        if(inventory.containsKey(card)){
            newAmount = inventory.get(card) + amount;
        } else {
            newAmount = amount;
        }

        inventory.put(card, newAmount);
        cardAmount += amount;
    }

    public void dealCard(Player targetPlayer, int amount) {
        Random random = new Random();
        List<Card> cards = new ArrayList<>(inventory.keySet());

        for(int i = 0; i < amount; i++) {
            Card randomCard = cards.get(random.nextInt(cards.size()));
            targetPlayer.drawCard(randomCard);
            updateCard(randomCard, -1);
        }
    }

    public int getCardAmount() {
        return cardAmount;
    }
}
