package calculator;

import java.util.ArrayList;

public class StringCalculator {
    public int calculate(String userInput) {
        ArrayList<String> delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");

        if (userInput.startsWith("//")) {
            if (userInput.contains("\\n")) {
                String newDelimiter = userInput.substring(2, userInput.indexOf("\\n"));
                delimiters.add(newDelimiter);
                userInput = userInput.substring(userInput.indexOf("\\n") + 2);
            } else {
                //ToDO:나중에 예외 처리
            }
        }
        String regex = String.join("|", delimiters);
        String[] splitByDelimiter = userInput.split(regex);
        int result = 0;
        for (String num : splitByDelimiter) {
            result += Integer.parseInt(num);
        }
        return result;
    }
}

//구분자만 들어오는 경우,숫자만 들어오는 경우
//커스텀 구분자가 숫자일 경우
//커스텀 구분자가 특수문자일 경우-정규표현식 공부할 것.