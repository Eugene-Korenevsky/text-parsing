package com.company.actionsWithText;

import java.util.ArrayList;

public class PunctuationMarksMaker {
    private ArrayList<String> punctuationMarks = new ArrayList<>();

    public ArrayList doPunctuationMarks(String text) {
        for (int i = 0; i < text.length() - 1; ++i) {
            String ss = String.valueOf(text.charAt(i));
            char dd = text.charAt(i + 1);
            if (ss.equals("!") || ss.equals("?") || ss.equals(".") &&
                    (dd == ' ')) {
                punctuationMarks.add(ss);
            }
        }
        String ss = String.valueOf(text.charAt(text.length() - 1));
        punctuationMarks.add(ss);
        return punctuationMarks;
    }
}
