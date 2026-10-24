package Question2;

public class Exercise {
    public int[] swapNumbers(int first, int second) {
         first-=second;
         second+=first;
         first=second-first;
         return new int [] {first,second};

       }
}
