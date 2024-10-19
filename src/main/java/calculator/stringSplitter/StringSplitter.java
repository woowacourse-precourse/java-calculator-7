package calculator.stringSplitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringSplitter {
    public String[] splitsString(String input){
        List<String> separator = getSeparator();
        String number = input;
        checkLastCharIsDigit(input);
        if(input.startsWith("//")){
            ensureCustomDelimiterExists(input);
            int endPoint = input.lastIndexOf("\\n");
            String customSeparators = input.substring(2,endPoint);
            validateSeparators(customSeparators);
            addSeparators(separator, customSeparators);
            number = input.substring(endPoint+2);
        }
        validateInput(separator, number);
        String calculateSeparator = getCalculateSeparator(separator);

        return number.split(calculateSeparator);
    }

    private static void addSeparators(List<String> separator, String customSeparators) {
        if(customSeparators.length() > 1){
            String[] splited = customSeparators.split("");
            for(String str : splited){
                separator.add(str);
            }
        }else{
            separator.add(customSeparators);
        }
    }

    private static String getCalculateSeparator(List<String> separator) {
        return separator.stream().map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }

    private static void validateInput(List<String> separator, String number) {
        for (char c : number.toCharArray()) {
            if(!Character.isDigit(c) && !separator.contains(String.valueOf(c))){
                throw new IllegalArgumentException("허용되지 않은 입력입니다.");
            }
        }
    }

    private static void validateSeparators(String customSeparators) {
        for(char c : customSeparators.toCharArray()){
            if(Character.isWhitespace(c)){
                throw new IllegalArgumentException("구분자에는 빈칸이 불가능합니다.");
            }else if(Character.isDigit(c)){
                throw new IllegalArgumentException("구분자에는 숫자가 들어갈 수 없습니다.");
            }
        }
    }

    private static void ensureCustomDelimiterExists(String input) {
        if(!input.contains("\\n")){
            throw new IllegalArgumentException("\\n가 없다면 커스텀 구분자를 사용할 수 없습니다."); // 예외발생
        }
    }

    private static void checkLastCharIsDigit(String input) {
        if(!Character.isDigit(input.charAt(input.length()-1))){
            throw new IllegalArgumentException("마지막은 숫자로 입력해주세요");
        }
    }

    private static List<String> getSeparator() {
        List<String>  separator = new ArrayList<>();
        separator.add(",");
        separator.add(":");
        return separator;
    }

}
