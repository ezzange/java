package org.example.enummm;

public enum Color {
    RED("Red"),
    ORANGE("Orange"),
    YELLOW("Yellow"),
    GREEN("Green"),
    BLUE("Blue"),
    INDIGO("Indigo"),
    VIOLET("Violet");

    private final String color;

    Color(String color) {
        this.color = color;
    }
    public String getColor(){
        return color;
    }
}
