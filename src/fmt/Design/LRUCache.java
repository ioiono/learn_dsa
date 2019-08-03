package fmt.Design;

import java.util.LinkedHashMap;

public class LRUCache {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer ret = map.remove(key);
        if (ret != null) {
            map.put(key, ret);
        } else {
            ret = -1;
        }
        return ret;
    }

    public void put(int key, int value) {
        map.remove(key);
        map.put(key, value);
        if (map.size() > capacity) {
            map.remove(map.keySet().iterator().next());
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
