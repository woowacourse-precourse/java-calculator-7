package calculator;

import calculator.model.DelimiterHandler;
import calculator.model.ExpressionHandler;
import calculator.view.ConsoleView;

import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {

        // 1. 입력 받기
        ConsoleView consoleView = new ConsoleView();
        String expression = consoleView.getExpression();

        // 2. custom 구분자 확인
        DelimiterHandler delimiterHandler = new DelimiterHandler();
        delimiterHandler.setDelimiter(expression);
        String delimiters = delimiterHandler.getAllDelimiters();
        boolean customDelimiterFlag = delimiterHandler.getCustomDelimiterFlag();

        // 3. 문자열 tokenizing
        ExpressionHandler expressionHandler = new ExpressionHandler(expression, delimiters, customDelimiterFlag);
        expressionHandler.filterExpression();

        StringTokenizer tokenizedExpression = expressionHandler.tokenizeExpression();

        // 4. 덧셈
        int result = expressionHandler.getSum(tokenizedExpression);

        // 5. 출력
        consoleView.showResult(result);
    }
}