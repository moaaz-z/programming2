
package Question1;

public class Exercise {
    
    public int countDigits(int number){
        int count =0;
        if (number ==0){
            return 1;
        }
        while(number!=0){
            count++;
            number /= 10;
        }
        return count;
    }
}