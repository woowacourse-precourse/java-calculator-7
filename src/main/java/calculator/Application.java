package calculator;

import calculator.controller.Divider;
import calculator.controller.Validation;
import calculator.model.Calculator;
import calculator.view.Input;
import calculator.view.Output;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        Validation validation = new Validation();
        Divider divider = new Divider();
        Calculator calculator = new Calculator();

        // 사용자로부터 문자열 입력 받기
        String userInput = input.getInput();

        // 문자열 유효성 검사
        if (validation.formValidate(userInput)) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }

        // 구분자 찾기
        char delimiter = validation.findDelimiter(userInput);

        // 문자열을 구분자로 분리
        String[] strArray = divider.spliter(userInput, delimiter);

        // 문자열 배열을 정수 배열로 변환
        int[] numArray = divider.strToNum(strArray);

        // 합계 계산
        int result = calculator.calculate(numArray);

        // 결과 출력
        output.showOutput(result);
    }
}

