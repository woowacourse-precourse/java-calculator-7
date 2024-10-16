package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();
//     계산을 수행하는 Calculator 생성
        Calculator calculator = new Calculator();

        String[] userInputNumbers = calculator.splitInput(userInput);

        int result = calculator.sumInput(userInputNumbers);

        System.out.println("결과 : " + result);
    }
}

//계산을 수행하는 클래스 분리
class Calculator {
    //  사용자의 입력을 구분자오 파싱하는 메서드
    public String[] splitInput(String userInput) {
        String delimiter = ",|:"; // 기본 구분자
        int customDelimiterIndex;

        // 커스텀 구분자가 있을 경우 처리
        if (userInput.startsWith("//")) {
            customDelimiterIndex = userInput.indexOf("\\n");
            delimiter = userInput.substring(2, customDelimiterIndex);
            userInput = userInput.substring(customDelimiterIndex + 2);
        }

        return userInput.split(delimiter);
    }

    //문자열에서 구분한 숫자를 더하는 메서드
    public int sumInput(String[] userInputNumbers) {
        int sum = 0;
        for (String userInputNumber : userInputNumbers) {
            sum += Integer.parseInt(userInputNumber);
        }
        return sum;
    }
}