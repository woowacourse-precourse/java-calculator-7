package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Application {

    public static String getCustomSeparator(String input){
        if(!input.startsWith("//")){
            return "[,:]";
        }
        if(!input.contains("\\n") || input.indexOf("\\n")==2){
            throw new IllegalArgumentException();
        }
        return "([,:]|" + Pattern.quote(input.substring(2,input.indexOf("\\n"))) + ")";
    }

    public static List<Long> extractNumbers(String input, String delimiterRegex){
        return Arrays.stream(input.split(delimiterRegex)).map(Application::stringToLong).toList();
    }

    public static Long stringToLong(String str){
        Long num = 0L;
        for(char i : str.toCharArray()){
            if(i < '0' || i>'9'){
                throw new IllegalArgumentException();
            }
            num *= 10;
            num += i-'0';
        }
        return num;
    }

    public static void main(String[] args) {
        String input = Console.readLine();
        String separator = getCustomSeparator(input);

        if(separator.length() != 4){
            input = input.substring(separator.length()-7);
        }

        extractNumbers(input, separator);
    }
}
