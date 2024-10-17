package calculator.service;

import calculator.enums.ErrorMessages;
import camp.nextstep.edu.missionutils.Console;

import static calculator.util.Validator.validateCustomDelimiter;

public class InputService {
    public String readInput() {
        //TODO: 사용자 입력 받기 및 검증 로직 구현
        try {
            String input = Console.readLine();
            validateCustomDelimiter(input);
            return input;
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_INPUT.getMessage());
        }
    }
}
