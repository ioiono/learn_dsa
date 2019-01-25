package fmt.StackAndDFS;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }

    // 3 x 1 adj + 2 x 2 adjs + 1 x 3 adjs
    public int islandPerimeter2(int[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int cur = getAdjs(grid, i, j);
                    switch (cur) {
                        case 0:
                            res += 4;
                            break;
                        case 1:
                            res += 3;
                            break;
                        case 2:
                            res += 2;
                            break;
                        case 3:
                            res += 1;
                            break;
                    }
                }
            }
        }
        return res;
    }

    private int getAdjs(int[][] grid, int i, int j) {
        int res = 0;
        // top
        if (j - 1 >= 0 && grid[i][j - 1] == 1) res++;
        if (i - 1 >= 0 && grid[i - 1][j] == 1) res++;
        if (i + 1 < grid.length && grid[i + 1][j] == 1) res++;
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) res++;

        return res;
    }

}
