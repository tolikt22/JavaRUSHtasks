//package com.javarush.task.task19.task1918;
///*
//Знакомство с тегами
//*/
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class Tmp {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(reader.readLine()));
//        reader.close();
//        StringBuilder sb = new StringBuilder();
//        while (bufferedFileReader.ready()) {
//            sb.append(bufferedFileReader.readLine());
//        }
//        String s = sb.toString().replaceAll("\r\n", "");
//        bufferedFileReader.close();
//
//        System.out.println(s);
//        String open = ("<" + args[0]), close = ("</" + args[0] + '>');
//        Map<Integer, String> tagMap = new TreeMap<>();
//        Map<Integer, String> stringMap = new TreeMap<>();
//        int idxOpen = 0, idxClose = 0;
//        for (int i = 0; i < s.length(); i++) {
//            idxOpen = s.indexOf(open, idxOpen + 1);
//            idxClose = s.indexOf(close, idxClose + 1);
//            tagMap.put(idxOpen, "open");
//            tagMap.put(idxClose, "close");
//        }
//        tagMap.remove(-1);
//        for (Map.Entry<Integer, String> entry : tagMap.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//        while (tagMap.containsValue("close")) {
//            for (Map.Entry<Integer,String> entry : tagMap.entrySet()){
//                if (entry.getValue().equals("close")){
//                    for (Map.Entry<Integer, String> entry1 : tagMap.entrySet()){
//
//                    }
//                }
//            }
//        }
//    }
//}
//
