package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();
        Validation.validateEmpty(userInput);

//     계산을 수행하는 Calculator 생성
        Calculator calculator = new Calculator();

        String[] userInputNumbers = calculator.splitInput(userInput);

        int result = calculator.sumInput(userInputNumbers);

        System.out.println("결과 : " + result);
    }
}

//계산을 수행하는 클래스 분리
class Calculator {
    //  사용자의 입력을 구분자로 파싱하는 메서드
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
            int tempInputNumber = Integer.parseInt(userInputNumber);
            Validation.validateNegativeNumber(tempInputNumber);
            sum += tempInputNumber;
        }
        return sum;
    }
}

class Validation {
    //입력이 비어있는 경우 예외 반환
    public static void validateEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }
    }

    //입력된 숫자에 음수가 있는 경우 예외 반환
    public static void validateNegativeNumber(int userInputNumber) {
        if (userInputNumber < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}