package calculator;

import calculator.domain.CharAnalyzer;
import calculator.domain.CustomDelimiter;
import calculator.domain.Delimiter;
import calculator.input.InputHandler;

public class Application {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();
        inputHandler.showMessage();
        String input = inputHandler.input();

        Delimiter delimiter = new Delimiter();
        CustomDelimiter customDelimiter = new CustomDelimiter();
        CharAnalyzer charAnalyzer = new CharAnalyzer(input, delimiter, customDelimiter);

        try {
            // 문자열을 분석하고 커스텀 구분자 등록
            charAnalyzer.analyzeAllChars();

            // 커스텀 구분자 등록 여부 확인
            if (delimiter.isRegisteredDelimiter(';')) {
                System.out.println("커스텀 구분자 ';'가 등록되었습니다.");
            } else {
                System.out.println("커스텀 구분자 ';'가 등록되지 않았습니다.");
            }

            // 기본 구분자 테스트 (예: 콤마, 콜론)
            char testDelimiter1 = ',';
            char testDelimiter2 = ':';

            if (delimiter.isRegisteredDelimiter(testDelimiter1)) {
                System.out.println("'" + testDelimiter1 + "'는 기본 구분자입니다.");
            } else {
                System.out.println("'" + testDelimiter1 + "'는 기본 구분자가 아닙니다.");
            }

            if (delimiter.isRegisteredDelimiter(testDelimiter2)) {
                System.out.println("'" + testDelimiter2 + "'는 기본 구분자입니다.");
            } else {
                System.out.println("'" + testDelimiter2 + "'는 기본 구분자가 아닙니다.");
            }

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }
}