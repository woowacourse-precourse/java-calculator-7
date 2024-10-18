package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {


    public static void sumNumbersFromLetters(String input){

        String[] tmp;

        if(input.startsWith("//")){
            String customSeparator = findCustomSeparator(input);
            String letters = input.substring(5);
            assert customSeparator != null;
            tmp = letters.split(customSeparator);
        }else{

            String separator = "[,:;]";
            tmp = input.split(separator);
        }



        System.out.println("결과 : " + sum(tmp));


    }

    private static int sum(String[] tokens){
        int total = 0;
        for(String token : tokens){
            total += Integer.parseInt(token.trim());
        }
        return total;
    }

    private static String findCustomSeparator(String input){
        input = input.replace("\\n", "\n"); // \\n을 실제 줄바꿈 \n으로 변환
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            return matcher.group(1);
        }
        return null;
    }




}
