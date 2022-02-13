package com.cooper.effective_java.chapter02.item07;

import java.util.Map;
import java.util.WeakHashMap;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> weakHashMap = new WeakHashMap<>();
        Integer key1 = 1000;
        Integer key2 = 2000;

        weakHashMap.put(key1, "one");
        weakHashMap.put(key2, "two");

        key1 = null;

        System.gc();

        weakHashMap.entrySet().forEach(System.out::println);
    }
}
