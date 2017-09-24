package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName, outFile = "", fileNamePath = null;
        Set<String> names = new TreeSet<>();

        while (!(fileName=reader.readLine()).equals("end")){
            names.add(fileName);
//            fileNamePath = fileName;
            outFile = fileName.substring(0,fileName.indexOf(".part"));

        }
        FileInputStream fis;
//        String path = new File("").getAbsolutePath()+"\\";
//        String path = new String(fileNamePath.substring(0,fileNamePath.lastIndexOf('\\')));
//        Path p = Paths.get(fileNamePath);
//        Path folder = p.getParent();
//        File newFile = new File(folder + "lion.avi");
        FileOutputStream fos = new FileOutputStream(outFile,true);

        for (String name : names){
            BufferedReader isrBufReader = new BufferedReader(new FileReader(name));
            while (isrBufReader.ready()){
                int data = isrBufReader.read();
                fos.write(data);
            }
//            fis = new FileInputStream(name);
//            byte[] buffer = new byte[fis.available()];
//            if (fis.available()>0) fis.read(buffer);
//            fos.write(buffer);
//            fis.close();
            isrBufReader.close();
        }
        fos.close();

//        System.out.println(Arrays.toString(names.toArray()));

//        while (fis.available() > 0) {
//            fis = new FileInputStream(fileName);
//        }
    }
}
