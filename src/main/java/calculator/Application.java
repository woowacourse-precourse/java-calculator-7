package calculator;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler();
        DelimiterHandler delimiterHandler = new DelimiterHandler();
        StringSplitter stringSplitter = new StringSplitter();
        Calculator calculator = new Calculator();
        ValidationHandler validationHandler = new ValidationHandler();
        OutputHandler outputHandler = new OutputHandler();

        // 문자열 입력
        String input = inputHandler.getInput();

        // Custom 구분자 처리
        String[] result = delimiterHandler.processCustomDelimiter(input);
        input = result[0]; // 수정된 input
        String delimiter = result[1]; // 수정된 delimiter


        // 문자열 분리하기
        String[] splitString = stringSplitter.splitString(input, delimiter);

        // 숫자 유효성 검사
        validationHandler.isNegativeNumber(splitString);

        // 문자열 계산
        String resultSum = calculator.calculateSum(splitString);

        // 결과 출력
        outputHandler.printOutput(resultSum);
    }
}
