package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class StringCalculator {
    public int calculate(String userInput) {
        ArrayList<String> delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");

        if (userInput.startsWith("//")) {
            if (userInput.contains("\\n")) {
                String newDelimiter = userInput.substring(2, userInput.indexOf("\\n"));
                System.out.println(newDelimiter);
                if (newDelimiter.matches("\\d+")) {
                    throw new IllegalArgumentException("잘못된 값을 입력하였습니다");
                }
                delimiters.add(newDelimiter);
                userInput = userInput.substring(userInput.indexOf("\\n") + 2);
            } else {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다");
            }
        }
        String regex = String.join("|", delimiters);
        System.out.println(userInput);
        String[] splitByDelimiter = userInput.split(regex);
        System.out.println(Arrays.toString(splitByDelimiter));
        System.out.println(splitByDelimiter[0]);
        int result = 0;
        for (String num : splitByDelimiter) {

            int addNum;
            try {
                if (num.isEmpty()) {
                    num = "0";
                }
                addNum = Integer.parseInt(num);
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