package com.shq.leetcode.经典150题.链表.LRU缓存;

import java.util.LinkedHashMap;

class LRUCache {

    int capacity;
    LinkedHashMap<Integer,Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>();
    }

    // 若key存在，返回val，更新为最近使用，更新为最近使用相当于将key删除重插
    // 若key不存在，返回-1
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Integer value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
        return value;
    }

    // 若key存在，更新key为最近使用
    // 若key不存在，进一步判断，容量是否到达上限
    // 若容量到达上限，将链表队首的元素删除；
    // 若未达到上线，直接新增元素
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
        if (cache.size() >= capacity) {
            // 插入key，并移除未使用的元素（思路被卡！！！！）
            Integer ordKey = cache.keySet().iterator().next();
            cache.remove(ordKey);
        }
        cache.put(key,value);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        System.out.println(lruCache.get(1));
        lruCache.put(4,4);
        System.out.println(lruCache.get(2));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */