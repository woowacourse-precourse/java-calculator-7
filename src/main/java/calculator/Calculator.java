package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    int result = 0;
    void print(){
        System.out.println(result);
    }
    String[] processing(String input) {
        String regex = "//(.*)\\\\n";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input.trim());
        System.out.println("Input: " + input);
        if (matcher.find()) {
            String customSplitter = matcher.group(1);
            System.out.println("Custom Splitter: " + customSplitter);
            String restOfInput = input.substring(matcher.end());

            return restOfInput.split(customSplitter);
        } else {
            System.out.println("No match found.");
            return input.split("[,;]");
        }
    }
    void calculate(String[] input){
        for(int i=0;i<input.length;i++){
            String s = input[i];
            this.result += Integer.valueOf(s);
        }
    }
}
