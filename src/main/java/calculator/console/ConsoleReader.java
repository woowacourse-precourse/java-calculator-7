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
            String customSeperator = "";
            Pattern pattern;
            Matcher matcher;

            if(target.contains("//") && target.contains("\\n")
            && target.startsWith("/")){
                int startIndex = target.indexOf("//")+2;
                int endIndex = target.indexOf("\\n");
                if(endIndex - startIndex != 1){ // 커스텀 문자가 없거나 두 개 이상인 경우
                    throw new IllegalArgumentException();
                }else{
                    customSeperator = Character.toString(target.charAt(startIndex));
                }
            }

            if(target.contains("-"))
                throw new IllegalArgumentException();

            if(customSeperator.charAt(0) > '0' && customSeperator.charAt(0) < '9') // 커스텀 문자가 숫자인 경우
                throw new IllegalArgumentException();

            if(customSeperator.equals("\\")) // 커스텀 문자가 이스케이프 문자인 경우
                customSeperator = "\\\\";

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
