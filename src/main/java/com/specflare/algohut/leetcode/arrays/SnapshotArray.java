package com.specflare.algohut.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1146. Snapshot Array: https://leetcode.com/problems/snapshot-array/
public class SnapshotArray {
    Map<Integer, Integer> currBuff;
    List<Map<Integer, Integer>> snapshots = new ArrayList<>();
    public SnapshotArray(int length) {
        currBuff = new HashMap<>();
    }

    public void set(int index, int val) {
        currBuff.put(index, val);
    }

    public int snap() {
        snapshots.add(new HashMap<>(currBuff));
        return snapshots.size() - 1;
    }

    public int get(int index, int snap_id) {
        return snap_id < snapshots.size() ? snapshots.get(snap_id).getOrDefault(index, 0) : 0;
    }

    public static void main(String[] args) {
        SnapshotArray sa = new SnapshotArray(44444);
        sa.set(34, 20);
        sa.set(22, 21);
        sa.snap();
        sa.snap();


        sa.set(34, 120);
        sa.set(22, 121);
        sa.snap();
        sa.snap();

        sa.set(34, 220);
        sa.set(22, 221);
        sa.snap();
        sa.snap();

        System.out.println(sa.get(34, 0));
        System.out.println(sa.get(22, 0));

        System.out.println(sa.get(34, 1));
        System.out.println(sa.get(22, 1));

        System.out.println(sa.get(34, 2));
        System.out.println(sa.get(22, 2));
    }
}
