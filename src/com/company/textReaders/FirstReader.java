package com.company.textReaders;

import com.company.textMakers.ParagraphMaker;
import com.company.exceptionsMassage.ExceptionMassage;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FirstReader implements TextReaders {
    private ParagraphMaker paragraphMaker;

    public FirstReader(ParagraphMaker paragraphMaker) {
        this.paragraphMaker = paragraphMaker;
    }

    @Override
    public void readText(File input) {
        String line;
        BufferedReader bufferedReader = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(input), StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(inputStreamReader);
            while ((line = bufferedReader.readLine()) != null) {
                if (line.length() > 1) {
                    paragraphMaker.doText(line);
                }
            }
        } catch (IOException e) {
            new ExceptionMassage().exceptionMassage(this.getClass().getName(), e.getMessage());
        } finally {
            paragraphMaker.lastLine();
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                new ExceptionMassage().exceptionMassage(this.getClass().getName(), e.getMessage());
            }
        }
    }
}
