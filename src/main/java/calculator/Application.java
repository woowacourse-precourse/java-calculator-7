package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	private static final String INPUT_REQUEST_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public static void main(String[] args) {
        System.out.println(INPUT_REQUEST_MESSAGE);
        
        // InputHandler로 입력 처리
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();
        
        // 구분자 추출 및 문자열 추출
        String delimiters = inputHandler.getDelimiters(input);
        String processedInput = inputHandler.getProcessedInput(input);
        
        // 문자열을 구분자로 분리
        StringSplitter splitter = new StringSplitter();
        String[] tokens = splitter.split(processedInput, delimiters);
        
        // 숫자 계산 및 예외 처리
        Calculator calculator = new Calculator();
        int sum = calculator.calculateSum(tokens);
        
        // 결과 출력
        System.out.println("결과 : " + sum);
    }
}