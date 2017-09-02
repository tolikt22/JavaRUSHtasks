package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(1.4,"Field1");
        labels.put(2.2,"Field2");
        labels.put(5.5,"Field3");
        labels.put(65.87,"Field4");
        labels.put(4.6,"Field5");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
