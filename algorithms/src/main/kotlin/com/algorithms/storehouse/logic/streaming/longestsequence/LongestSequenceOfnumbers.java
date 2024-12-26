package com.algorithms.storehouse.logic.streaming.longestsequence;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class LongestSequenceOfnumbers {
    public static void main(String[] args) throws IOException {
        File in = new File("C:\\src\\algorithms-storehouse\\src\\main\\java\\algorythmchallenge\\strings\\in.txt");
        List<Integer> list = new ArrayList<>();
        InputStream is = new FileInputStream(in);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Integer.valueOf(line));
            }
        }
        TreeMap<Integer, Integer> countrs = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) {
                if (i > 0 && list.get(i - 1) == 1) {
                    int lastKey = countrs.lastKey();
                    countrs.replace(lastKey, countrs.get(lastKey) + 1);
                } else {
                    countrs.put(i, 1);
                }

            }
        }
        int max = Collections.max(countrs.values());
        System.out.println(max);
    }
}