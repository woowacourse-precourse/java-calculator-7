package calculator;

import calculator.model.Delimiter;
import calculator.view.ConsoleView;

public class Application {
    public static void main(String[] args) {

        // 1. 입력 받기
        ConsoleView consoleView = new ConsoleView();
        String expression = consoleView.getExpression();

        // 2. custom 구분자 확인
        Delimiter delimiter = new Delimiter();
        char customDelimiter = delimiter.getDelimiter(expression);

        // 테스트용 커스텀 구분자 출력
        System.out.println(customDelimiter);


    }
}