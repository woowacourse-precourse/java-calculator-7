package calculator.stringSplitter;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringSplitter {
    public String[] splitsString(String input){
        List<String>  separator = new ArrayList<>();
        separator.add(",");
        separator.add(":");
        String number = input;
        if(input.startsWith("//")){
            int endPoint = input.lastIndexOf("\\n");
            if(endPoint == -1){
                throw new IllegalArgumentException("\\n가 없다면 커스텀 구분자를 사용할 수 없습니다."); // 예외발생
            }

            String customSeparators = input.substring(2,endPoint);
            for(char c : customSeparators.toCharArray()){
                if(Character.isWhitespace(c)){
                    throw new IllegalArgumentException("구분자에는 빈칸이 불가능합니다.");
                }else if(Character.isDigit(c)){
                    throw new IllegalArgumentException("구분자에는 숫자가 들어갈 수 없습니다.");
                }
            }
            if(customSeparators.length() > 1){
                String[] splited = customSeparators.split("");
                for(String str : splited){
                    separator.add(Pattern.quote(str));
                }
            }else{
                separator.add(Pattern.quote(customSeparators));
            }
            number = input.substring(endPoint+2);
        }
        String calculateSeparator = separator.stream().collect(Collectors.joining("|"));
        return number.split(calculateSeparator);
    }

    public static void main(String[] args) {
        StringSplitter stp = new StringSplitter();
        String tmp = Console.readLine();
        System.out.println("입력받은 문자의 수 " + tmp.length());
        System.out.println(tmp);
        String[] test = stp.splitsString(tmp);
        System.out.println("test = " + Arrays.toString(test));
    }
}
