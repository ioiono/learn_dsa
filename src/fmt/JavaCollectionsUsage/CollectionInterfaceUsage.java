package fmt.JavaCollectionsUsage;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionInterfaceUsage {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(6);

        System.out.println(list.stream()
                               .filter(x -> x > 2)
                               .collect(Collectors.summarizingInt(value -> value))
                               .getSum());

        List<Integer> list2 = new ArrayList<>(list);
        list2.add(1);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(7);
        System.out.println(list2);
//        list2.retainAll(list);
//        list2.removeAll(list);
        System.out.println(list2.stream()
                                .map(Objects::toString)
                                .collect(Collectors.joining(" ")));


        for (Iterator<Integer> it2 = list2.iterator(); it2.hasNext(); ) {
            if (it2.next() < 5) {
                it2.remove();
            }
        }
        //same as  list2.removeIf(integer -> integer < 5);

        System.out.println(list2.stream()
                                .map(Objects::toString)
                                .collect(Collectors.joining(" ")));

        // Collection Interface Array Operations
        Object[] a = list.toArray();
        Integer[] arr = list.toArray(new Integer[0]);




    }
}
