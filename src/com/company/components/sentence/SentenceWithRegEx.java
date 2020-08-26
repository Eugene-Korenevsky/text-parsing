package com.company.components.sentence;

import com.company.components.Component;
import com.company.operationsWithSubstring.DeleteSubstring;
import com.company.components.Email;
import com.company.components.MobileNumber;
import com.company.components.word.Word;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceWithRegEx implements Component {
    private StringBuilder stringBuilder = new StringBuilder();
    private LinkedList components = new LinkedList();
    private String sentence, regexForWord, regexForEmail, regexForPhoneNumber;
    private Component component;

    public SentenceWithRegEx(String sentence, String regexForWord, String regexForEmail,
                             String regexForPhoneNumber) {
        this.sentence = sentence;
        this.regexForWord = regexForWord;
        this.regexForEmail = regexForEmail;
        this.regexForPhoneNumber = regexForPhoneNumber;
    }

    @Override
    public void operation() {
        String[] array;
        DeleteSubstring deleteSubstring = new DeleteSubstring();
        Pattern pattern = Pattern.compile(regexForEmail);
        Pattern pattern1 = Pattern.compile(regexForPhoneNumber);
        sentence = deleteSubstring.deleteSubstring(sentence, 'i', 'p');
        array = sentence.trim().split(regexForWord);
        for (int i = 0, n = array.length; i < n; ++i) {
            String s = array[i];
            Matcher matcher = pattern.matcher(s);
            Matcher matcher1 = pattern1.matcher(s);
            if (matcher.find()) {
                add(new Email(s));
            } else if (matcher1.find()) {
                add(new MobileNumber(s));
            } else {
                add(new Word(array[i]));
            }
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
            stringBuilder.append(" ").append(component.getResult());
        }
        return stringBuilder.toString();
    }
}
