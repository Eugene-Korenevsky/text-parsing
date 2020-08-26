package com.company.components;

import java.util.ArrayList;

public class Email implements Component {
    private String email;

    public Email(String email) {
        this.email = email;
    }

    @Override
    public void operation() {
    }

    @Override
    public void add(Component component) {

    }

    @Override
    public void remove(Component component){
    }

    @Override
    public Component getChild(int child) {
        return null;
    }

    @Override
    public String getResult() {
        return email;
    }
}
