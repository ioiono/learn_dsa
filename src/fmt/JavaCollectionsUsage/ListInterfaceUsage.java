package fmt.JavaCollectionsUsage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListInterfaceUsage {
    public static <E> void swap(List<E> a, int i, int j) {
        E tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(-1);
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(7);
        list.add(2);

        Collections.sort(list);
        System.out.println("SORT-> " + list);
        System.out.println(Collections.indexOfSubList(list, new ArrayList<>(Arrays.asList(2, 2, 5))));
        System.out.println(Collections.binarySearch(list, 7));
        Collections.shuffle(list);
        System.out.println("SHUFFLE-> " + list);
        Collections.rotate(list, 2);
        System.out.println("ROTATE-> "+ list);
    }
}
