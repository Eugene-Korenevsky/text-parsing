package com.company.textParser;

import com.company.textMakers.ParagraphMaker;
import com.company.fileWriters.FirstWriter;
import com.company.textReaders.FirstReader;

import java.io.*;

public class FirstTextParser implements MyTextParsers {
    private File input;
    private File output;

    public FirstTextParser(File input, File output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void parseText() {
        FirstWriter firstWriter = new FirstWriter(output, "UTF-8");
        ParagraphMaker line2 = new ParagraphMaker(firstWriter);
        firstWriter.clear();
        FirstReader firstReader = new FirstReader(line2);
        firstReader.readText(input);
    }
}
