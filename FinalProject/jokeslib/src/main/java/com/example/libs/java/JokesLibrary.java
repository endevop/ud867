package com.example.libs.java;

public class JokesLibrary {
    private int lastJoke = 0;
    private static final JokesLibrary instance = new JokesLibrary();

    // using UNIX fortune cookies to provide some content
    private static final String[] jokesArray = new String[]{
        "All programmers are playwrights and all computers are lousy actors.",
        "Always borrow money from a pessimist; he doesn't expect to be paid back.",
        "If all the salmon caught in Canada in one year were laid end to end across the Sahara Desert, the smell would be absolutely awful.",
        "\"As part of the conversion, computer specialists rewrote 1,500 programs -- a process that traditionally requires some debugging.\"\n" +
                "\t\t--- USA Today, referring to the IRS switchover to a new\n" +
                "\t\t    computer system.",
        "Cloning is the sincerest form of flattery.",
        "Every program has at least one bug and can be shortened by at least one " +
                "instruction -- from which, by induction, one can deduce that every " +
                "program can be reduced to one instruction which doesn't work."
    };

    private JokesLibrary() {}

    public static final JokesLibrary getInstance() {
        return instance;
    }

    public synchronized String getJoke() {
        if(lastJoke == jokesArray.length)
            lastJoke = 0;
        return jokesArray[lastJoke++];
    }
}
