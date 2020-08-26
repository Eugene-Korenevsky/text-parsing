package com.company.components.paragraph;

import com.company.components.Component;
import com.company.components.punctuationMarks.PunctuationMarks;
import com.company.components.sentence.SentenceWithRegEx;
import com.company.actionsWithText.PunctuationMarksMaker;
import com.company.actionsWithText.SentenceManufacturer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Paragraph implements Component {
    private StringBuilder stringBuilder = new StringBuilder();
    private LinkedList components = new LinkedList<>();
    private Component component;
    private String paragraph;

    public Paragraph(String paragraph) {
        this.paragraph = paragraph;
    }

    @Override
    public void operation() {
        ArrayList punctuationMarks = new ArrayList<>();
        ArrayList sentences = new ArrayList();
        PunctuationMarksMaker punctuationMarksMaker = new PunctuationMarksMaker();
        SentenceManufacturer sentenceManufacturer = new SentenceManufacturer();
        punctuationMarks = punctuationMarksMaker.doPunctuationMarks(paragraph);
        sentences = sentenceManufacturer.doSentences(paragraph);
        for (int i = 0, n = sentences.size(); i < n; ++i) {
            add(new SentenceWithRegEx((String) sentences.get(i), "\\s", "(^\\S*@\\S*)",
                    "(\\+\\d{3}\\(\\d{2}\\)\\S{9})"));
            add(new PunctuationMarks((String) punctuationMarks.get(i)));
        }
        for (int i = 0, n = components.size(); i < components.size(); ++i) {
            component = getChild(i);
            component.operation();
        }
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public Component getChild(int child) {
        return (Component) components.get(child);
    }

    @Override
    public String getResult() {
        Iterator iterator = components.iterator();
        while (iterator.hasNext()) {
            component = (Component) components.remove(0);
            stringBuilder.append(component.getResult());
        }
        return stringBuilder.toString() + "\n";
    }
}
