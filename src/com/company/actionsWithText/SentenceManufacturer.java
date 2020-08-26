package com.company.actionsWithText;

import java.util.ArrayList;

public class SentenceManufacturer {
    private ArrayList<String> sentences = new ArrayList<>();

    public ArrayList doSentences(String text) {
        int f = 0;
        for (int i = 0; i < text.length() - 1; ++i) {
            String ss = String.valueOf(text.charAt(i));
            char after = text.charAt(i + 1);
            if (ss.equals("!") || ss.equals("?") || ss.equals(".") &&
                    (after == ' ')) {
                String sss = text.substring(f, i);
                f = i + 1;
                sentences.add(sss);
            }
        }
        String dff = text.substring(f, text.length() - 1);
        sentences.add(dff);
        return sentences;
    }

}
