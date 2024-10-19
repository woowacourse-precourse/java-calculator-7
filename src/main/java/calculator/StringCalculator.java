package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {
    public long calculate(String userInput) {
        ArrayList<String> delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");

        if (userInput.startsWith("//")) {
            if (userInput.contains("\\n")) {
                String newDelimiter = userInput.substring(2, userInput.indexOf("\\n"));
                System.out.println(newDelimiter);
                if (newDelimiter.isEmpty() || newDelimiter.matches("\\d+")) {
                    throw new IllegalArgumentException("잘못된 값을 입력하였습니다");
                }
                delimiters.add(Pattern.quote(newDelimiter));
                userInput = userInput.substring(userInput.lastIndexOf("\\n") + 2);
            } else {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다");
            }
        }
        String regex = String.join("|", delimiters);
        System.out.println(userInput);
        String[] splitByDelimiter = userInput.split(regex);
        System.out.println(Arrays.toString(splitByDelimiter));
        System.out.println(splitByDelimiter[0]);
        long result = 0;
        for (String num : splitByDelimiter) {

            long addNum;
            try {
                if (num.isEmpty()) {
                    num = "0";
                }
                addNum = Long.parseLong(num);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
            if (addNum < 0) {
                throw new IllegalArgumentException();
            }
            result += addNum;
        }
        return result;
    }
}

//구분자만 들어오는 경우,숫자만 들어오는 경우
//커스텀 구분자가 숫자일 경우
//커스텀 구분자가 특수문자일 경우-정규표현식 공부할 것.