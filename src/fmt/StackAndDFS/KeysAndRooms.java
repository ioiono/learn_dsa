package fmt.StackAndDFS;

import java.security.Key;
import java.util.*;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> keys = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        // add keys from room 0
        for (int k : rooms.get(0)) {
            keys.offer(k);
        }
        while (!keys.isEmpty()) {
            int key = keys.poll();
            if (!visited.add(key)) continue;
            for (int k : rooms.get(key)) { // get key from key-th room
                keys.offer(k);
            }
        }
        return visited.size() == rooms.size();
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(new ArrayList<>(Arrays.asList(3, 4, 6, 9)));
        rooms.add(new ArrayList<>());
        rooms.add(new ArrayList<>(Arrays.asList(2, 5)));
        rooms.add(new ArrayList<>());
        rooms.add(new ArrayList<>(Arrays.asList(8)));
        rooms.add(new ArrayList<>());
        rooms.add(new ArrayList<>(Arrays.asList(7)));
        rooms.add(new ArrayList<>());
        rooms.add(new ArrayList<>(Arrays.asList(1)));
        rooms.add(new ArrayList<>());
        System.out.println(rooms);
        KeysAndRooms kar = new KeysAndRooms();
        System.out.println(kar.canVisitAllRooms(rooms));
        List<List<Integer>> empty = new ArrayList<>();
        empty.add(new ArrayList<>());
        System.out.println(kar.canVisitAllRooms(empty));
    }
}
