package calculator.service;

import camp.nextstep.edu.missionutils.Console;

import static calculator.util.Validator.validateCustomDelimiter;

public class InputService {
    public String readInput() {
        //TODO: 사용자 입력 받기 및 검증 로직 구현
        String input = changeEmptyToZero(Console.readLine());
        validateCustomDelimiter(input);
        return input;
    }

    private String changeEmptyToZero(String input){
        return input.isEmpty() ? "0" : input;
    }
}
