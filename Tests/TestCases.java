package Tests;
import java.util.Arrays;

public class TestCases {
     public static void main(String[] args) {
        testProblem1();
        testProblem2();
        testProblem3();
        testProblem4();
    }
    public static void testProblem1() {
         System.out.println("--- Problem 1: countDigits ---");

        Question1.Exercise ex = new Question1.Exercise();

        System.out.println(ex.countDigits(123456));
        System.out.println(ex.countDigits(0));
        System.out.println(ex.countDigits(-987));
        System.out.println(ex.countDigits(7));
    }
    public static void testProblem2(){
         System.out.println("--- Problem 2: swapNumbers ---");
         Question2.Exercise ex = new Question2.Exercise();
         int[] result = ex.swapNumbers(5, 13);
         System.out.println(Arrays.toString(result));

    }
    public static void testProblem3() {
    System.out.println("--- Problem 3: twoSum ---");

    Question3.Exercise ex = new Question3.Exercise();

    int[] result1 = ex.twoSum(new int[] {2, 7, 11, 15}, 9);
    int[] result2 = ex.twoSum(new int[] {3, 2, 4}, 6);
    int[] result3 = ex.twoSum(new int[] {1, 2, 3}, 10);

    System.out.println(Arrays.toString(result1));
    System.out.println(Arrays.toString(result2));
    System.out.println(Arrays.toString(result3));
}
public static void testProblem4() {
        System.out.println("--- Problem 4: compressString ---");

        Question4.Exercise ex = new Question4.Exercise();

        System.out.println(ex.compressString("aabcc"));
        System.out.println(ex.compressString("abc"));
        System.out.println(ex.compressString(""));
        System.out.println(ex.compressString("aaabbc"));
        System.out.println(ex.compressString("aabaa"));
        System.out.println(ex.compressString("a"));

        System.out.println();
    }


}