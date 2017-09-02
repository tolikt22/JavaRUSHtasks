package com.javarush.task.task15.task1527;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        //add your code here
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //javarush.ru/alpha/index.html?lvl=15&view&name=Aobjmigo&&obj==3.14&name=&obj=djsd.cd&oobj=3.0&obj=1&objj=2.3&obj=aaa
        String params = s.substring(s.indexOf("?") + 1);
        String[] splitParts;
        splitParts = params.split("&");

        //Split every item in splitParts array by "=" and put to Map as key and value
        LinkedHashMap<String, String> paramters = new LinkedHashMap<String, String>();
        for (int i = 0; i < splitParts.length; i++) {
            int posEqualChar = splitParts[i].indexOf("=");
            if (posEqualChar < 0) { //no param, only key exist
                paramters.put(splitParts[i], null);
                continue;
            }
            String key = splitParts[i].substring(0, posEqualChar);
            String value = splitParts[i].substring(posEqualChar + 1);
            paramters.put(key, value);
        }

        //key printing
        for (String key : paramters.keySet()) {
            System.out.print(key + " ");
        }

        //print alert
        System.out.println();
        String objParameter = paramters.get("obj");
        if (objParameter == null) {
            return;
        }

        try {
            alert(Double.parseDouble(objParameter));
        } catch (NumberFormatException e) {
            alert(objParameter);
        }
    }


    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}