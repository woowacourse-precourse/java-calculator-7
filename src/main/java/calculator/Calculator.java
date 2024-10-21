package calculator;

import Validate.InputValidate;

public class Calculator {
    public String calculator() {
        InputValidate inputValidate = new InputValidate();
        inputValidate.validate();
        if (inputValidate.empty()) return case1();
        if (inputValidate.oneNumber()) return case2(inputValidate.userInput);
        if (inputValidate.custom()) return case3(inputValidate.userInput);
        return case4(inputValidate.userInput);
    }

    // 빈 문자열
    public String case1() {
        return "0";
    }

    // 숫자 하나
    public String case2(String userInput) {
        return userInput;
    }

    // 커스텀 구문자
    public String case3(String userInput) {
        String separators = ",:";
        separators += userInput.charAt(2);
        String[] input = userInput.split("["+separators+"]");

        // 구문자로 나눈 숫자가 유효한지 검사
    }

    // 기본 구문자
    public String case4(String userInput) {
        String separators =",:";
        String[] input = userInput.split("["+separators+"]");

        // 구문자로 나눈 숫자가 유효한지 검사
    }


}
