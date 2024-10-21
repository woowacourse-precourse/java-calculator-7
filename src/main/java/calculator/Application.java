package calculator;

public class Application {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        Calculator calculator = new Calculator();
        UserOutput userOutput = new UserOutput();

        // 사용자 입력 받기
        String input = userInput.getUserInput();

        // 결과 계산
        int result = calculator.getResult(input);

        // 결과 출력
        userOutput.printResult(result);
    }
}
