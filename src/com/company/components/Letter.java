package com.company.components;

import java.util.ArrayList;

public class Letter implements Component {
    private ArrayList components = new ArrayList();
    private char aChar;

    public Letter(char aChar) {
        this.aChar = aChar;
    }

    @Override
    public void operation() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(Component component) {

    }

    @Override
    public void remove(Component component) {

    }

    @Override
    public Component getChild(int child) {
        return (Component) components.get(child);
    }

    public String getResult() {
        return String.valueOf(aChar);
    }
}
