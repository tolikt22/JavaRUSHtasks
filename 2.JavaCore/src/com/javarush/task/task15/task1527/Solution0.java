package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution0 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<String> params = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //add your code here
        addStringPartsToList();
        ArrayList<String> leftParamArray = getLeftParamPart(params);
        for (int i = 0; i < leftParamArray.size(); i++) {
            System.out.print(leftParamArray.get(i) + " ");
        }
        System.out.println();

        String objValueS;
        Double objValueD;

        for (int i = 0; i < params.size(); i++) {
            Pattern p = Pattern.compile("^obj=.+");
            Matcher m = p.matcher(params.get(i));
            if (m.matches()) {
                objValueS = findObjectValue(params.get(i));
                if (checkDouble(objValueS)) {
                    objValueD = Double.parseDouble(objValueS);
                    alert(objValueD);
                } else alert(objValueS);
            }
        }
    }

    private static ArrayList<String> getLeftParamPart(ArrayList<String> list) {
        String newString;
        ArrayList<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("=")) {
                newString = list.get(i).substring(0, findFirstDivider(list.get(i), '='));
            } else {
                newString = list.get(i);
            }
            newList.add(i, newString);
        }
        return newList;
    }

    private static boolean checkDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            return false;
        }
    }

    private static String findObjectValue(String param) {
        String objValue = param.substring(findFirstDivider(param, '=') + 1, param.length());
        return objValue;
    }

    public static void addStringPartsToList() throws IOException {
        String string = reader.readLine();
        int i = 0;
        String subStr;
        int currentDiv = findFirstDivider(string, '?');
        int nextDivider = findNextDivider(string, 0);

        while (currentDiv != nextDivider) {
            subStr = string.substring(currentDiv + 1, nextDivider);
            if (!subStr.trim().isEmpty()) params.add(i++, subStr);
            currentDiv = nextDivider;
            nextDivider = findNextDivider(string, nextDivider);
        }
        addLastString(currentDiv, string);
    }

    public static void addLastString(int currentDiv, String string) {
        String subStr = string.substring(currentDiv + 1, string.length());
        params.add(subStr);
    }

    public static int findFirstDivider(String s, char ch) {
        int firstDivider = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ch) {
                firstDivider = i;
                break;
            }
        }
        return firstDivider;
    }

    public static int findNextDivider(String s, int divider) {
        char[] chars = s.toCharArray();
        for (int i = divider + 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == '&') {
                divider = i;
                break;
            }
        }
        return divider;
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
