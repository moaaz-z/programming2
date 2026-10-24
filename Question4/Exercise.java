package Question4;

public class Exercise {
    public String compressString(String str) {
        if (str .length()== 0){
            return "";
        }
        StringBuilder result = new StringBuilder();
        int count = 1; //cuz in the begining the first character already exists
        
        for (int i=1;i<str.length();i++){
            
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                result.append(str.charAt(i - 1));
                result.append(count);
                count = 1;
            }
        }
        result.append(str.charAt(str.length() - 1));//returns the last char in the array cuz the loop finished before appending
        result.append(count);
        return result.toString(); 

       }
}
