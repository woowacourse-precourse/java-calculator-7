package calculator;

import Validate.InputValidate;
import Validate.NumValidate;

public class Calculator {
    public String calculator() {
        InputValidate inputValidate = new InputValidate();
        inputValidate.validate();
        if (inputValidate.empty()) return case1();
        if (inputValidate.oneNumber()) return case2(inputValidate.userInput);

        String separators = ",:";
        if (inputValidate.custom()) {
            separators += inputValidate.userInput.charAt(2);
        }
        return case3(inputValidate.userInput, separators);
    }

    // 빈 문자열
    public String case1() {
        return "0";
    }

    // 숫자 하나
    public String case2(String userInput) {
        return userInput;
    }

    // 구문자
    public String case3(String userInput, String separators) {

        String[] input = userInput.split("[" + separators + "]");
        int[] num = new int[input.length];
        int sum = 0;
        // 구문자로 나눈 숫자가 유효한지 검사
        NumValidate numValidate = new NumValidate();
        num = numValidate.validate(input);

        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        String result = String.valueOf(sum);
        return result;
    }


}
