package tech.timaert.cluno;

import java.util.HashMap;
import java.util.Map;

public class Pile {
    private Map<Card, Integer> inventory;
    private int cardAmount;

    public Pile() {
        inventory = new HashMap<>();
        cardAmount = 0;
    }

    public void addCard(Card card, int amount){
        Integer newAmount;

        if(inventory.containsKey(card)){
            newAmount = inventory.get(card) + amount;
        } else {
            newAmount = amount;
        }

        inventory.put(card, newAmount);
        cardAmount += amount;
    }

    public int getCardAmount() {
        return cardAmount;
    }
}
