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
        try {
            return Arrays.stream(input.split(delimiterRegex)).map(Long::parseLong).toList();
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        String input = Console.readLine();
        String separator = getCustomSeparator(input);

        if(separator.length() != 4){
            input = input.substring(separator.length()-7);
        }

    }
}
