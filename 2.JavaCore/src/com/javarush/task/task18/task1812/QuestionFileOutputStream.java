package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    AmigoOutputStream aos;

    public QuestionFileOutputStream(AmigoOutputStream aos) {
        this.aos = aos;
    }

    @Override
    public void flush() throws IOException {
        aos.flush();
    }

    @Override
    public void write(int b) throws IOException {
        aos.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        aos.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        aos.write(b,off,len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        String answer = reader.readLine();
        if (answer.equals("Д")) {aos.close();}
    }
}

