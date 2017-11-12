package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке //??
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(this.fileName,true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution("d:/task2022_1.dat");
        sol.writeObject("Данные для проверки-1");
        sol.close();
        //Saving
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/task2022_2.dat"));
        oos.writeObject(sol);
        oos.close();
        //Loading
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/task2022_2.dat"));
        Solution loadedSol = (Solution) ois.readObject();
        ois.close();
        loadedSol.writeObject("Данные для проверки-2");
        loadedSol.close();
    }
}
