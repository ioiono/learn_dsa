package fmt.JavaCollectionsUsage;


import java.util.*;
import java.util.stream.Collectors;

public class SetInterfaceUsage {

    public static void main(String[] args) {
        /*
         * Here's a simple but useful Set idiom. Suppose you have a Collection, c, and you want to create another Collection
         * containing the same elements but with all duplicates eliminated. The following one-liner does the trick.
         */
        // Collection<Type> noDups = new HashSet<Type>(c);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        Set<Integer> noDups = new HashSet<>(list);
        System.out.println(noDups);

        // with java8
        //noinspection SimplifyStreamApiCallChains
        System.out.println(list.stream().collect(Collectors.toSet()));


        //Using JDK 8 Aggregate Operations:
        Set<String> distinctWords = Arrays.asList(args).stream()
                                          .collect(Collectors.toSet());
        System.out.println(distinctWords.size() +
                " distinct words: " +
                distinctWords);
        // Using the for-each Construct:
        Set<String> s = new HashSet<String>();
        for (String a : args)
            s.add(a);
        System.out.println(s.size() + " distinct words: " + s);

        /*
          Note that the code always refers to the Collection by its interface type (Set) rather than by
          its implementation type. This is a strongly recommended programming practice because it gives
          you the flexibility to change implementations merely by changing the constructor

          ref: https://docs.oracle.com/javase/tutorial/collections/interfaces/set.html
         */
        /**
         * Bulk operations are particularly well suited to Sets; when applied, they perform standard set-algebraic operations. Suppose s1 and s2 are sets. Here's what bulk operations do:
         *
         * s1.containsAll(s2) — returns true if s2 is a subset of s1. (s2 is a subset of s1 if set s1 contains all of the elements in s2.)
         * s1.addAll(s2) — transforms s1 into the union of s1 and s2. (The union of two sets is the set containing all of the elements contained in either set.)
         * s1.retainAll(s2) — transforms s1 into the intersection of s1 and s2. (The intersection of two sets is the set containing only the elements common to both sets.)
         * s1.removeAll(s2) — transforms s1 into the (asymmetric) set difference of s1 and s2. (For example, the set difference of s1 minus s2 is the set containing all of the elements found in s1 but not in s2.)
         *
         *
         * Set<Type> union = new HashSet<Type>(s1);
         * union.addAll(s2);
         *
         * Set<Type> intersection = new HashSet<Type>(s1);
         * intersection.retainAll(s2);
         *
         * Set<Type> difference = new HashSet<Type>(s1);
         * difference.removeAll(s2);
         */
        Set<String> uniques = new HashSet<String>();
        Set<String> dups = new HashSet<String>();

        for (String a : args)
            if (!uniques.add(a))
                dups.add(a);

        // Destructive set-difference
        uniques.removeAll(dups);

        System.out.println("Unique words:    " + uniques);
        System.out.println("Duplicate words: " + dups);

        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));
        Set<Integer> symmetricDiff = new HashSet<Integer>(s1);
        symmetricDiff.addAll(s2);
        Set<Integer> tmp = new HashSet<Integer>(s1);
        tmp.retainAll(s2);
        symmetricDiff.removeAll(tmp);

        System.out.println(symmetricDiff);
    }
}
