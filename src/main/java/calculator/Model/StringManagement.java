package calculator.Model;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class StringManagement {
    String delimiter = ",:";

    public String checkString(String input) {
        if (Pattern.matches("\\d+", input))
            throw new IllegalArgumentException("숫자만 입력하셨습니다.");
        if (Pattern.matches("^[,:]+$", input))
            throw new IllegalArgumentException("구분자만 입력하셨습니다");
        return input;
    }

    public String checkDelimiter(String input){
        for (char ch : input.toCharArray()) {
            if (!Character.isLetterOrDigit(ch) && delimiter.indexOf(ch) == -1) {
                throw new IllegalArgumentException();
            }
        }
        return input;
    }

    public String customDelimiter(String input){
        input = checkString(input);
        int start = input.indexOf("//");
        int last = input.indexOf("\\n");
        if(start != -1 && last != -1){
            delimiter += input.substring(2,3);
            input = input.substring(5);
        }
        else if(start != -1 || last != -1){
            throw new IllegalArgumentException("구분자를 분리할 수 없습니다.");
        }
        checkDelimiter(input);
        return input;
    }

    public ArrayList<Double> strToDouble(String input) {
        ArrayList<Double> splitNum = new ArrayList<>();
        String[] splitInput = input.split("["+delimiter+"]");
        for (String s : splitInput) {
            if (s.contains("-")) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            double num = Double.parseDouble(s);
            splitNum.add(num);
        }
        return splitNum;
    }
}
