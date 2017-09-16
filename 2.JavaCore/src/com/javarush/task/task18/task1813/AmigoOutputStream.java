package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "c:/tmp/result.txt";
    private FileOutputStream original;

    public AmigoOutputStream(FileOutputStream fos) throws FileNotFoundException {
        super(fileName);
        this.original = fos;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void write(int b) throws IOException{original.write(b);}
    public void write(byte[] b) throws IOException{original.write(b);}
    public void write(byte[] b, int off, int len) throws IOException{original.write(b,off,len);}

    @Override
    public void close() throws IOException {
        flush();
        write("JavaRush © All rights reserved.".getBytes());
        original.close();
    }

    @Override
    public void flush() throws IOException {original.flush();}
}
