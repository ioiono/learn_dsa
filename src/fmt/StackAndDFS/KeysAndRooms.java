package fmt.StackAndDFS;

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

    // DFS, change queue above to stack XD
    public boolean canVisitAllRoomsDFS(List<List<Integer>> rooms) {
        Stack<Integer> keys = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        ///////////////
        // choice 1
//        visited.add(0);
//         add keys from room 0
//        for (int k : rooms.get(0)) {
//            keys.push(k);
//        }
        ////////////////
        //choice 2
        keys.add(0);
        ///////////////
        while (!keys.isEmpty()) {
            int key = keys.pop();
            if (!visited.add(key)) continue;
            for (int k : rooms.get(key)) { // get key from key-th room
                keys.push(k);
            }
        }
        return visited.size() == rooms.size();
    }


    public boolean canVisitAllRoomsDFSREC(List<List<Integer>> rooms) {
        Set<Integer> keys = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, keys, visited, 0);
        return visited.size() == rooms.size();
    }

    private void dfs(List<List<Integer>> rooms, Set<Integer> keys, Set<Integer> visited, int key) {
        if (!visited.add(key)) return;
        keys.addAll(rooms.get(key));
        for (int k : rooms.get(key)) {
            dfs(rooms, keys, visited, k);
        }
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

        System.out.println("===========FALSE==========");

        System.out.println(kar.canVisitAllRooms(rooms));
        System.out.println(kar.canVisitAllRoomsDFS(rooms));
        System.out.println(kar.canVisitAllRoomsDFSREC(rooms));



        List<List<Integer>> empty = new ArrayList<>();
        empty.add(new ArrayList<>());
        System.out.println("===========TRUE==========");

        System.out.println(kar.canVisitAllRooms(empty));
        System.out.println(kar.canVisitAllRoomsDFS(empty));
        System.out.println(kar.canVisitAllRoomsDFSREC(empty));

        System.out.println("===========TRUE==========");
        List<List<Integer>> rooms2 = new ArrayList<>();
        rooms2.add(new ArrayList<>(Arrays.asList(1)));
        rooms2.add(new ArrayList<>(Arrays.asList(2)));
        rooms2.add(new ArrayList<>(Arrays.asList(3)));
        rooms2.add(new ArrayList<>());
        System.out.println(kar.canVisitAllRooms(rooms2));
        System.out.println(kar.canVisitAllRoomsDFS(rooms2));
        System.out.println(kar.canVisitAllRoomsDFSREC(rooms2));
    }
}
