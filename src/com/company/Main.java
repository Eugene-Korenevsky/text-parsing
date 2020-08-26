package com.company;

import com.company.textParser.FirstTextParser;
import com.company.textParser.MyTextParsers;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        File input = new File("src" + File.separator + "com" + File.separator + "company" +
                File.separator + "resource" + File.separator + "doc6.txt");
        File output = new File("src" + File.separator + "com" + File.separator + "company" + File.separator +
                "resource" + File.separator + "text.txt");
        MyTextParsers myTextParser = new FirstTextParser(input, output);
        myTextParser.parseText();
    }
}
