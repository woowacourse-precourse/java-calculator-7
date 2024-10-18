package calculator.console;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleReader {
    public String read(){
        return Validator.validate(Console.readLine());
    }

    private static class Validator{
        public static String validate(String target) {
            String patternString;
            char customSeperator = 0;
            Pattern pattern;
            Matcher matcher;

            if(target.contains("//") && target.contains("\\n")
            && target.startsWith("/")){
                int startIndex = target.indexOf("//");
                int endIndex = target.indexOf("\\n");
                if(endIndex - startIndex != 1){ // 커스텀 문자가 두 개 이상인 경우
                    throw new IllegalArgumentException();
                }else{
                    customSeperator = target.charAt(startIndex+2);
                }
            }

            if(customSeperator > '0' && customSeperator < '9') // 커스텀 문자가 숫자인 경우
                throw new IllegalArgumentException();

            patternString = "[^0-9:," + customSeperator + "]";
            pattern = Pattern.compile(patternString);
            matcher = pattern.matcher(target);
            if (matcher.matches()) { // 기본 구분자와 커스텀 구분자, 숫자 이외의 글자가 있는 경우
                throw new IllegalArgumentException();
            }

            return target;
        }
    }
}
