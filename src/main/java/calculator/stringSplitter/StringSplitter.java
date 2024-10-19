package calculator.stringSplitter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringSplitter {
    public String[] splitsString(String input){
        List<String>  separator = new ArrayList<>();
        separator.add(",");
        separator.add(":");
        String number = input;
        if(!Character.isDigit(input.charAt(input.length()-1))){
            throw new IllegalArgumentException("마지막은 숫자로 입력해주세요");
        }
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
                    separator.add(str);
                }
            }else{
                separator.add(customSeparators);
            }
            number = input.substring(endPoint+2);
        }

        String calculateSeparator = separator.stream().map(Pattern::quote)
                .collect(Collectors.joining("|"));

        return number.split(calculateSeparator);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add(",");
        list.add(":");
        list.add(Pattern.quote("+"));
        list.add(Pattern.quote("@"));
        String regex = list.stream().collect(Collectors.joining("|"));
        String tmp ="1+3@4:5,6"; // true
        String tmp2 = "1-3@4:5"; // false
        String tmp3 = "1+3!4,5@6;"; // false


    }
    private static void check(String tmp, Pattern pattern){
        Matcher matcher = pattern.matcher(tmp);
        if (matcher.matches()) {
            System.out.println("매칭됨: \"" + tmp + "\"");
        } else {
            System.out.println("매칭되지 않음: \"" + tmp + "\"");
        }

    }
}
