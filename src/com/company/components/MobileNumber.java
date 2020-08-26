package com.company.components;

import java.util.ArrayList;

public class MobileNumber implements Component {
    private ArrayList components = new ArrayList();
    private String mobileNumber;

    public MobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public void operation() {

    }

    @Override
    public void add(Component component){
    }

    @Override
    public void remove(Component component) {

    }

    @Override
    public Component getChild(int child) {
        return null;
    }

    @Override
    public String getResult() {
        return mobileNumber;
    }
}
