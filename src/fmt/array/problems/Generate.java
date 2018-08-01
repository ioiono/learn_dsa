package fmt.array.problems;

import java.util.ArrayList;
import java.util.List;

public class Generate {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            allrows.add(new ArrayList<>(row)); // ps
        }
        return allrows;
    }

    private static List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<>();
        row.add(0, 1);
        for (int i = 0; i < rowIndex; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
        }
        return row;

    }

    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(getRow(5));
    }
}
