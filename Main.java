import java.util.*;

public class Main {

    private static Integer[] arr = new Integer[]{0, 1, 2};
    private static int[] array = new int[]{1, 5, 7, 8, 9, 11, 18, 19, 20, 25};
    private static ArrayList<String> strings = new ArrayList<String>();

    public static void main(String[] args) {
        Permutation perm = new Permutation(arr);
        perm.printPermutn();
        System.out.println(findTarget(array, 11));
        strings.add("abc");
        strings.add("bcd");
        strings.add("bbb");
        strings.add("ace");
        strings.add("snb");
        strings.add("aaaa");
        strings.add("bbbb");
        strings.add("eeee");

        System.out.println(new ArrayList<String>(groupString(strings)).toString());
        Calc calc = new Calc();
        System.out.println(calc.parse("7 + 85 - 2"));
    }

    private static int findTarget(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private static ArrayList<String> groupString(List<String> input) {
        ArrayList<String> output = new ArrayList<String>();

        for (String s : input) {
            if (s.charAt(0) == 'a') output.add(s);
        }
        for (String s : input) {
            if (s.charAt(0) == 'b') output.add(s);
        }
        for (String s : input) {
            if (s.charAt(0) != 'a' && s.charAt(0) != 'b') output.add(s);
        }
        return output;
    }
}
