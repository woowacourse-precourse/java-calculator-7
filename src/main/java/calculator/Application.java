package calculator;

import calculator.domain.CharExtractor;
import calculator.domain.Delimiter;
import calculator.input.InputHandler;

public class Application {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();
        inputHandler.showMessage();
        String input = inputHandler.input();

        CharExtractor charExtractor = new CharExtractor(input);

        while (charExtractor.hasNext()) {
            Character currentChar = charExtractor.nextChar();
            System.out.println("현재 문자: " + currentChar);
        }

        Delimiter delimiter = new Delimiter();

        System.out.println("기본 구분자: " + delimiter.getDelimiterSet());

        delimiter.addCustomDelimiter('@');
        System.out.println("커스텀 구분자 추가 후: " + delimiter.getDelimiterSet());

        char testDelimiter = '/';
        if (delimiter.isRegisteredDelimiter(testDelimiter)) {
            System.out.println(testDelimiter + "는 등록된 구분자입니다.");
        } else {
            System.out.println(testDelimiter + "는 등록되지 않은 구분자입니다.");
        }
    }
}