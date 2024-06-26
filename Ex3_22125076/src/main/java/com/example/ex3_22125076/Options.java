package com.example.ex3_22125076;

public enum Options {
    YES, NO, NONE;

    public static Options fromInt(int i) {
        switch(i) {
            case 0:
                return YES;
            case 1:
                return NO;
            default:
                return NONE;
        }
    }

    public int toInt() {
        switch(this) {
            case YES:
                return 0;
            case NO:
                return 1;
            default:
                return -1;
        }
    }

    public String toString() {
        switch(this) {
            case YES:
                return "Yes";
            case NO:
                return "No";
            default:
                return "None";
        }
    }
}