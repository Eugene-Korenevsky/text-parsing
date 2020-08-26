package com.company.textMakers;

import com.company.components.Component;
import com.company.components.paragraph.Paragraph;
import com.company.fileWriters.FirstWriter;

public class ParagraphMaker implements TextMaker {
    private StringBuilder stringBuilder = new StringBuilder();
    private boolean first = false;
    private FirstWriter firstWriter;
    private Component component;

    public ParagraphMaker(FirstWriter firstWriter) {
        this.firstWriter = firstWriter;
    }

    @Override
    public void doText(String line) {
        char s = line.charAt(0);
        if (!first && (s == ' ' || s == '\t')) {
            if (stringBuilder.length() != 0) {
                component = new Paragraph(stringBuilder.toString());
                component.operation();
                firstWriter.write(component.getResult());
                stringBuilder.delete(0, stringBuilder.length());
            }
            stringBuilder.append(line);
        } else {
            stringBuilder.append(line);
            first = false;
        }
    }

    public void lastLine() {
        component = new Paragraph(stringBuilder.toString());
        component.operation();
        firstWriter.write(component.getResult());
        stringBuilder.delete(0, stringBuilder.length());
        firstWriter.close();
    }

    public String getResult() {
        return component.getResult();
    }
}
