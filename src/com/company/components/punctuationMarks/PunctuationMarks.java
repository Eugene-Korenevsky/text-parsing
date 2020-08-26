package com.company.components.punctuationMarks;


import com.company.components.Component;

public class PunctuationMarks implements Component {
    private String mark;

    public PunctuationMarks(String mark) {
        this.mark = mark;
    }

    @Override
    public void operation() {
    }

    @Override
    public void add(Component component) {

    }

    @Override
    public void remove(Component component) {

    }

    @Override
    public Component getChild(int child) {
        return null;
    }

    @Override
    public String getResult()
    {
        return mark.trim();
    }
}
