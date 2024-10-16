package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();
        Validation.validateEmptyInput(userInput); //입력이 비어있는 경우 예외처리

//     계산을 수행하는 Calculator 생성
        Calculator calculator = new Calculator();

        String[] userInputNumbers = calculator.splitInput(userInput);

        Validation.validateProperInput(userInputNumbers); //입력된 숫자가 양수가 아닌 경우 오류에 맞는 예외처리

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
            sum += Integer.parseInt(userInputNumber);
        }
        return sum;
    }
}

class Validation {
    //입력이 비어있는 경우 예외 반환
    public static void validateEmptyInput(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }
    }

    //입력된 숫자가 양의 정수가 아닌 경우 오류에 맞는 예외 반환
    public static void validateProperInput(String[] userInputNumbers) {
        for (String userInputNumber : userInputNumbers) {
            if (userInputNumber.isEmpty()) {
                throw new IllegalArgumentException("구분자를 연속으로 입력할 수 없습니다.");
            }
            if (!userInputNumber.matches("[0-9]+")) {
                throw new IllegalArgumentException("계산식에는 숫자만 입력할 수 있습니다.");
            }
            if (Integer.parseInt(userInputNumber) < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        }
    }
}