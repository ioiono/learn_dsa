package fmt.Backtracking;

import java.util.*;

class Op {
    String op;
    double val;
    double left;
    double right;

    Op(double val, double left, String op, double right) {
        this.left = left;
        this.right = right;
        this.val = val;
        this.op = op;
    }

    @Override
    public String toString() {
        return "(" + val + ") = [" + left + " " + op + " " + right + "]";
    }
}

public class TwentyFourGame {
    private final double eps = 1e-9;
    //private
    //    List<Double> build(List<Double> list, double d) {
    //        List<Double> tmp = new ArrayList<>(list);
    //        tmp.add(d);
    //        return tmp;
    //    }
    private Stack<Op> opStack;

    private String getFormula(Stack<Op> opStack) {

        Op one = opStack.pop();
        Op two = opStack.pop();
        Op three = opStack.pop();
        String s = three.left + " " + three.op + " " + three.right;
        s = "(" + s + ")";
        if (Math.abs(three.val - two.right) < eps) {
            s = two.left + " " + two.op + " " + s;

        } else {
            s = s + " " + two.op + " " + two.right;

        }
        s = "(" + s + ")";

        if (Math.abs(two.val - one.right) < eps) {
            s = one.left + " " + one.op + " " + s;
        } else {
            s = s + " " + one.op + " " + one.right;
        }

        return s;
    }

    private String buildF(Op op) {
        return op.left + " " + op.op + " " + op.right;
    }

    private String build(Op op) {
        return "(" + op.left + " " + op.op + " " + op.right + ")";
    }

    private String getF(Stack<Op> opStack) {
        List<Op> list = new ArrayList<>(opStack);
        String s;
        Op tmp = list.get(0);
        s = buildF(tmp);
        s = "(" + s + ")";

        for (int i = 1; i < list.size(); i++) {
            Op cur = list.get(i);
            if (Math.abs(tmp.val - list.get(i).right) < eps) {
                s = cur.left + " " + cur.op + " " + s;
            } else {
                s = s + " " + cur.op + "  " + cur.right;
            }
            if (i != list.size() - 1) {
                s = "(" + s + ")";
            }
            tmp = list.get(i);
        }
        return s;
    }

    private String getF2(Stack<Op> opStack) {
        List<Op> list = new ArrayList<>(opStack);
        String s;

        List<Op> inits = new ArrayList<>();

        Op first = list.get(0);
        s = build(first);

        inits.add(first);
        list.remove(first);

        for (int i = 0; i < list.size(); i++) {

            Op cur = list.get(i);
            Op l = helper(inits, cur.left);
            Op r = helper(inits, cur.right);
            if (l != null && r != null) {
                s = build(l) + " " + cur.op + " " + build(r);
            } else if (r != null) {
                s = cur.left + " " + cur.op + " " + s;
                s = "(" + s + ")";
            } else if (l != null) {
                s = s + " " + cur.op + " " + cur.right;
                s = "(" + s + ")";
            } else {

            }
            inits.add(cur);

        }

        return s;
    }


    private Op helper(List<Op> list, double val) {
        for (Op op : list) {
            if (Math.abs(val - op.val) < eps) {
                list.remove(op);
                return op;
            }
        }
        return null;
    }

    boolean dfs(List<Double> list) {
        if (list.size() == 0) return false;
        if (list.size() == 1) {
            //
            //            if (Math.abs(list.get(0) - 24.0) < eps) {
            //                System.out.println(getF(opStack));
            //                System.out.println("FORMULA: " + getFormula(opStack));
            //            }

            return Math.abs(list.get(0) - 24.0) < eps;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {

                List<Double> cur = new ArrayList<>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j) {
                        cur.add(list.get(k));
                    }
                }

                double a = list.get(i);
                double b = list.get(j);
                List<Op> vars = new ArrayList<>();
                vars.add(new Op(a + b, a, "+", b));
                vars.add(new Op(a - b, a, "-", b));
                vars.add(new Op(b - a, b, "-", a));
                vars.add(new Op(a * b, a, "*", b));
                if (b > eps) {
                    vars.add(new Op(a / b, a, "/", b));
                }
                if (a > eps) {
                    vars.add(new Op(b / a, b, "/", a));
                }
                // beats only 5.4
                //                for (double d : vars) {
                //                    if(dfs(build(cur, d))) return true;
                //                }
                // beats 68
                for (Op d : vars) {
                    cur.add(d.val);
                    opStack.push(d);
                    if (dfs(cur)) return true;
                    cur.remove(cur.size() - 1);
                    opStack.pop();
                }
            }
        }
        return false;
    }

    // another version with
    boolean dfs2(List<Double> list) {
        if (list.size() == 0) return false;
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24.0) < eps;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;

                List<Double> cur = new ArrayList<>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j) {
                        cur.add(list.get(k));
                    }
                }

                double a = list.get(i);
                double b = list.get(j);
                // because of the range of j, here only need to calculate four res
                List<Double> vars = new ArrayList<>();
                vars.add(a + b);
                vars.add(a - b);
                vars.add(a * b);
                if (b > eps) {
                    vars.add(a / b);
                }

                for (double d : vars) {
                    cur.add(d);
                    if (dfs2(cur)) return true;
                    cur.remove(cur.size() - 1);
                }
            }
        }
        return false;
    }

    public boolean judgePoint24(int[] nums) {
        this.opStack = new Stack<>();
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        return dfs(list);
        //        return dfs2(list);
    }


    public static void main(String[] args) {
        int[] nums0 = new int[]{3, 3, 8, 8};
        int[] nums1 = new int[]{9, 4, 8, 4};
        int[] nums2 = new int[]{4, 1, 8, 7};

        List<int[]> list = new ArrayList<>(Arrays.asList(
                new int[]{3, 3, 8, 8},
                new int[]{9, 4, 8, 4},
                new int[]{4, 1, 8, 7},
                new int[]{3, 9, 4, 8},
                new int[]{2, 14, 8, 4}
        ));


        TwentyFourGame t = new TwentyFourGame();
        System.out.println(Arrays.toString(nums0));
        long tic = System.currentTimeMillis();
        System.out.println(t.judgePoint24(nums0));

        long toc = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (toc - tic) + " ms");

        System.out.println("FORMULA: " + t.getF(t.opStack));
        System.out.println("FORMULA: " + t.getFormula(t.opStack));

        System.out.println("===========================================");

        for (int[] nums : list) {
            System.out.println(t.judgePoint24(nums));
            System.out.println("Numbers: " + Arrays.toString(nums));
            System.out.println(t.opStack);
//            System.out.println("FORMULA: " + t.getF(t.opStack));
            System.out.println("FORMULA: " + t.getF2(t.opStack));
//            System.out.println("FORMULA: " + t.getFormula(t.opStack));
            System.out.println("===========================================");
        }

        //        System.out.println(t.judgePoint24(new int[]{1, 2, 3, 4}));
        //                System.out.println(t.judgePoint24(nums1));
        //        System.out.println(t.judgePoint242(nums0));
        //        System.out.println(t.judgePoint242(nums1));
        //        System.out.println(t.judgePoint242(nums2));
    }

    public boolean judgePoint242(int[] nums) {
        List<Double> ret = new ArrayList<>();
        for (int num : nums) {
            ret.add((double) num);
        }
        return solve(ret);
    }

    boolean solve(List<Double> nums) {
        if (nums.size() == 0) return false;
        if (nums.size() == 1) return Math.abs(nums.get(0) - 24) < 1e-6;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    List<Double> nums2 = new ArrayList<>();
                    for (int k = 0; k < n; k++) {
                        if (i != k && j != k) {
                            nums2.add(nums.get(k));
                        }
                    }
                    for (int l = 0; l < 4; l++) {
                        if (l < 2 && j > i) continue;
                        if (l == 0) nums2.add(nums.get(i) + nums.get(j));
                        if (l == 1) nums2.add(nums.get(i) * nums.get(j));
                        if (l == 2) nums2.add(nums.get(i) - nums.get(j));
                        if (l == 3) {
                            if (nums.get(j) != 0) {
                                nums2.add(nums.get(i) / nums.get(j));
                            } else {
                                continue;
                            }
                        }
                        if (solve(nums2)) return true;
                        nums2.remove(nums2.size() - 1);
                    }

                }

            }
        }
        return false;
    }

}
