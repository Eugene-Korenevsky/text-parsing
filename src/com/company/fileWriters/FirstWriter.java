package com.company.fileWriters;

import com.company.exceptionsMassage.ExceptionMassage;

import java.io.*;

public class FirstWriter {
    private Writer writer;
    private File file;

    public FirstWriter(File file, String charsetName) {
        this.file = file;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true), charsetName));
        } catch (IOException e) {
            new ExceptionMassage().exceptionMassage(this.getClass().getName(), e.getMessage());
        }

    }

    public void clear() {
        PrintWriter writer1 = null;
        try {
            writer1 = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            new ExceptionMassage().exceptionMassage(this.getClass().getName(), e.getMessage());
        } finally {
            if (writer1 != null) {
                writer1.close();
            }
        }
    }

    public void write(String s) {
        try {
            if (s.length() > 2) {
                writer.write(s);
            }
        } catch (IOException e) {
            new ExceptionMassage().exceptionMassage(this.getClass().getName(), e.getMessage());
        }

    }

    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            new ExceptionMassage().exceptionMassage(this.getClass().getName(), e.getMessage());
        }
    }
}
