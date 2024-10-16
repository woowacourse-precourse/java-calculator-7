package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();
//     계산을 수행하는 Calculator 생성
        Calculator calculator = new Calculator();

        String[] userInputNumbers = calculator.splitInput(userInput);

        for (String userInputNumber : userInputNumbers) {
            System.out.println(userInputNumber);
        }
    }
}

//계산을 수행하는 클래스 분리
class Calculator {
    public String[] splitInput(String userInput) {
        String delimiter = ",|:"; // 기본 구분자
        return userInput.split(delimiter);
    }
}