package com.modernJava.functionalPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 4, 9);

        List<List<Integer>> subsets = subsets(list);
        System.out.println(subsets);
    }

    static List<List<Integer>> subsets(List<Integer> list) {
        if (list.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }
        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());

        List<List<Integer>> subans = subsets(rest);
        List<List<Integer>> subans2 = insertAll(first, subans);
        return concat(subans, subans2);
    }

    static List<List<Integer>> insertAll(int first, List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }
        return result;
    }

    static List<List<Integer>> concat(List<List<Integer>> a, List<List<Integer>> b) {
        List<List<Integer>> r = new ArrayList<>(a);
        r.addAll(b);
        return r;
    }
}
