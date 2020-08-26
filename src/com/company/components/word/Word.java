package com.company.components.word;

import com.company.components.Component;
import com.company.components.Letter;
import com.company.components.punctuationMarks.PunctuationMarks;
import com.company.exceptionsMassage.ExceptionMassage;

import java.util.ArrayList;

public class Word implements Component {
    private StringBuilder stringBuilder = new StringBuilder();
    private ArrayList components = new ArrayList();
    private String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public void operation() {
        String last;
        try {
            for (int i = 0, n = word.length(); i < n; ++i) {
                last = String.valueOf(word.charAt(i));
                if (last.equals(",") || last.equals(":") || last.equals(";")) {
                    add(new PunctuationMarks(last));
                } else {
                    add(new Letter(word.charAt(i)));
                }
            }
        } catch (IndexOutOfBoundsException e) {
            new ExceptionMassage().exceptionMassage(this.getClass().getName(), e.getMessage());
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
        String result;
        Component component;
        for (int i = 0, n = components.size(); i < n; ++i) {
            component = getChild(i);
            stringBuilder.append(component.getResult());
        }
        result = stringBuilder.toString();
        return result;
    }
}
