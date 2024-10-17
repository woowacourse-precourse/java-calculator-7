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
        char customDelimiter = delimiterHandler.getDelimiter(expression); // 사용되지 않는 문제 발생
        boolean customDelimiterFlag = delimiterHandler.getCustomDelimiterFlag();

        // 3. 문자열 tokenizing
        ExpressionHandler expressionHandler = new ExpressionHandler();
        expression = expressionHandler.filterExpression(expression, customDelimiterFlag);

        StringTokenizer tokenizedExpression = expressionHandler.tokenizeExpression(expression);



    }
}