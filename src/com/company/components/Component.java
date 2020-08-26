package com.company.components;

import java.io.IOException;

public interface Component {
    public void operation() ;
    public void add(Component component);
    public void remove(Component component);
    public Component getChild(int child);
    public String getResult();
}
