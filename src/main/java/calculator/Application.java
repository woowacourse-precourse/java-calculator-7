package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

/**
 * packageName    : calculator
 * fileName       : Application
 * author         : ehgur062300
 * date           : 2024-10-18
 * description    : 가독성 및 유지보수성을 고려해서 구현
 * ===========================================================
 * DATE              AUTHOR                 NOTE
 * -----------------------------------------------------------
 * 2024-10-18      ehgur062300           version 1.0
 */

public class Application {

    private static final String BASIC_SEPARATOR = ":";
    private static final String CUSTOM_SEPARATOR_PREFIX = "//";
    private static final String NEWLINE_INDICATOR = "\\n";

    public static void main(String[] args) {
        Application app = new Application();

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        try {
            String additionFormula = Console.readLine();
            String separator = app.getSeparator(additionFormula);

            additionFormula = app.extractFormula(additionFormula);
            app.validateInput(additionFormula,separator);

        } catch (NoSuchElementException e) {
            // Console.readLine()이 "" 일 경우 0 출력

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다");

        } finally {
            Console.close();
    }

    }

    // 구분자 추출
    private String getSeparator(String value){
        if (isCustom(value)) {
            return getCustomSeparator(value);
        }
        return BASIC_SEPARATOR;
    }

    // 커스텀 구분자 추출
    private String getCustomSeparator(String value){
        int separatorEndIndex = value.indexOf(NEWLINE_INDICATOR);
        return value.substring(2, separatorEndIndex);
    }

    // 실사용할 수식 추출
    private String extractFormula(String value) {
        if (isCustom(value)) {
            int formulaStartIndex = value.indexOf(NEWLINE_INDICATOR) + NEWLINE_INDICATOR.length();
            return value.substring(formulaStartIndex);
        }
        return value.replaceAll(",", BASIC_SEPARATOR);
    }

    // 유효성 검사
    private void validateInput(String value, String separator) {
        for (String number : value.split(separator)) {
            // String -> int 변환 메서드
        }
    }

    // 구분자가 기본인지 커스텀인지 판단
    private boolean isCustom(String value) {
        return (value.startsWith(CUSTOM_SEPARATOR_PREFIX) && value.contains(NEWLINE_INDICATOR));
    }
}