package calculator;

import java.util.HashSet;
import java.util.Set;

public class Calculator {

    private Set<Character> separators = new HashSet<>();

    public  void addSeparator(String str, int start, int end) {
        for(int i = start+2; i < end; i++) {
            separators.add(str.charAt(i));
        }
    }

    public int calculateSum(String str) {
        int result = 0;
        String numberBuffer = "";
        for(int i = 0; i < str.length(); i++) {
            char charValue = str.charAt(i);
            if(separators.contains(charValue)) {
                if(numberBuffer.equals(""))
                    return -1;
                result += Integer.parseInt(numberBuffer);
                numberBuffer = "";
            }
            else if(Character.isDigit(charValue)) {
                numberBuffer += charValue;
            }
            else {
                return -1;
            }
        }
        result+= Integer.parseInt(numberBuffer);
        return result;
    }

    public int sumNumbers(String str){
        separators.add(':');
        separators.add(',');
        int result = 0;
        if(!Character.isDigit(str.charAt(0))){
            int idx1 = str.indexOf("//");
            int idx2 = str.indexOf("\\n");
            if(idx1 == -1|| idx2 == -1 ||idx1 > 0|| idx2+2 == str.length())
                throw new IllegalArgumentException("Error");

            else {
                addSeparator(str.substring(idx1, idx2+2),idx1, idx2);
                str = str.substring(idx2+2, str.length());

            }
        }
        return calculateSum(str);
    }
}

