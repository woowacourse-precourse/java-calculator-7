package calculator;

import camp.nextstep.edu.missionutils.Console;

import javax.xml.validation.Validator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();

        InputValidator inputValidator = new InputValidator(input);
        inputValidator.isValidateInput();

        StringCalculator stringCalculator = new StringCalculator(input);
        System.out.println("결과 : " + stringCalculator.add());
    }
}
