package tech.timaert.cluno;

public class Card {
    private Color color;
    private Type type;
    private int value;

    public Card(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public Card(Color color, Type type, int value) {
        this(color, type);
        this.value = value;
    }

    public Card(Type type) {
        if(type == Type.WILD || type == Type.WILD_DRAW_FOUR) {
            this.type = type;
        }
    }
}
