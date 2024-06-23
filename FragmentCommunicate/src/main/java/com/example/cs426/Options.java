package com.example.cs426;

public enum Options {
    LOVE, NORMAL, HATE, NONE;

    public String toString() {
        switch(this) {
            case LOVE: return "Love";
            case NORMAL: return "Normal";
            case HATE: return "Hate";
            case NONE: return "None";
            default: throw new IllegalArgumentException();
        }
    }
}
