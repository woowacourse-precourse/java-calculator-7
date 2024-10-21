package calculator.controller;

import calculator.service.Calculator;
import calculator.service.CheckDelimiterType;
import calculator.service.DelimiterExtractor;
import calculator.service.NumExtractor;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculateController {

    // 사용자가 애플리케이션을 실행하면 적절히 처리하는 메소드
    public static void run(){
        String userInput = InputView.getUserInput();

        // 사용자가 아무것도 입력하지 않았다면 0 출력
        if(userInput.isEmpty()){
            OutputView.printOutput("0");
        }

        // 사용자의 입력값이 기본 구분자 형식인 경우
        else if (CheckDelimiterType.isBasicDelimiter(userInput)) {
            // 기본 구분자를 기반으로 숫차 추출
            String[] extractedNums = NumExtractor.extractNumbersWithBasicDelimiters(userInput);
            OutputView.printOutput(Calculator.calculateSum(extractedNums));
        }

        // 사용자의 입력값이 커스텀 구분자 형식인 경우
        else {
            // 커스텀 구분자를 먼저 추출
            String customDelimiter = DelimiterExtractor.extractDelimiter(userInput);
            // 커스텀 구분자를 기반으로 숫자 추출
            String[] extractedNums = NumExtractor.extractNumbersWithCustomDelimiter(userInput, customDelimiter);
            OutputView.printOutput(Calculator.calculateSum(extractedNums));
        }
    }
}
