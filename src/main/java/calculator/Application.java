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

        String additionFormula = Console.readLine();
        String separator = app.getSeparator(additionFormula);



    }

    // 구분자 추출
    private String getSeparator(String value){
        if (isCustom(value)) {
            // 커스텀 구분자 추출 메서드
        }
        return BASIC_SEPARATOR;
    }

    // 구분자가 기본인지 커스텀인지 판단
    private boolean isCustom(String value) {
        return (value.startsWith(CUSTOM_SEPARATOR_PREFIX) && value.contains(NEWLINE_INDICATOR));
    }
}