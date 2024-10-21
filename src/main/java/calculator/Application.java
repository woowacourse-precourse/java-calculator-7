package calculator;

public class Application {
	private static final String INPUT_REQUEST_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
	private static final String RESULT_MESSAGE = "결과 : ";
	
    public static void main(String[] args) {
        System.out.println(INPUT_REQUEST_MESSAGE);
        
        // InputHandler로 입력 처리
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();
        
        // 구분자 추출 및 문자열 추출
        String delimiters = inputHandler.getDelimiters(input);
        String processedInput = inputHandler.getProcessedInput(input);
        
        // 입력 문자열이 비었을 경우 0 반환
        if (processedInput == null) {
            System.out.println(RESULT_MESSAGE + 0);
            return;  // 프로그램 종료
        }
        
        // 문자열을 구분자로 분리
        StringSplitter splitter = new StringSplitter();
        String[] tokens = splitter.split(processedInput, delimiters);
        
        // 숫자 계산 및 예외 처리
        Calculator calculator = new Calculator();
        int sum = calculator.calculateSum(tokens);
        
        // 결과 출력
        System.out.println(RESULT_MESSAGE + sum);
    }
}