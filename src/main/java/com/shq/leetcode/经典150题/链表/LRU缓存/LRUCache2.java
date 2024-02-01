package com.shq.leetcode.经典150题.链表.LRU缓存;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache2(int capacity) {
        super(capacity,0.75F, true);
        this.capacity = capacity;
    }

    // LinkedHashMap完全继承了HashMap的 put(Key,Value) 方法
    // 只是对put(Key,Value)方法所调用的recordAccess方法和addEntry方法进行了重写
    // addEntry方法中还调用了removeEldestEntry方法，该方法是用来被重写的，
    // 一般如果用LinkedHashmap实现LRU算法，就要重写removeEldestEntry方法
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }



}
