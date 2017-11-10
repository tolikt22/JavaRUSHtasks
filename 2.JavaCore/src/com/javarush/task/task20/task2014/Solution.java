package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        System.out.println(new Solution(4));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/tempfile"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/tempfile"));
        Solution savedObject = new Solution(5);
        oos.writeObject(savedObject);
        Solution loadedObject;
        loadedObject = (Solution) ois.readObject();
        System.out.println(savedObject);
        System.out.println(loadedObject);
        System.out.println(savedObject.string.equals(loadedObject.string));
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
