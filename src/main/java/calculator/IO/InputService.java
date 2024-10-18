package calculator.IO;

import camp.nextstep.edu.missionutils.Console;
import static calculator.Message.Message.INPUT_MESSAGE;

public class InputService {
    private String formula;
    private String customSeparator = null;

    // 덧셈할 문자열 입력 받기
    public void readFormula() {
        System.out.println(INPUT_MESSAGE);
        formula = (Console.readLine());
    }

    // 문자열 검사하기
    public void checkValidFormula() {
        // 문자열에 아무 값도 입력되지 않은 경우
        if (isBlankFormula())
            formula = "0";

        // 커스텀 구분자 설정
        checkCustomSeparator();
    }

    // 문자열이 아무 것도 입력되지 않은 경우
    public Boolean isBlankFormula() {
        return formula.isBlank();
    }

    // 커스텀 구분자가 존재시 커스텀 구분자 설정
    public void checkCustomSeparator() {
        // 커스텀 구분자가 존재할 수 있는 길이인지 확인
        if (formula.length() < 5)
            return ;

        // 커스텀 구분자 존재하는지 확인
        if (formula.charAt(0) == '/' && formula.charAt(1) == '/') {
            int idx = 2;

            while (idx < formula.length() - 1)
            {
                if (formula.charAt(idx) == '\\' && formula.charAt(idx + 1) == 'n')
                {
                    // 구분자를 설정 및 커스텀 구분자 설정 부를 문자열에서 제외
                    customSeparator = (formula.substring(2, idx));
                    formula = formula.substring(idx + 2);
                    return ;
                }
                idx++;
            }
        }
    }

    // 커스텀 구분자 리턴
    public String getCustomSeparator() {
        return customSeparator;
    }

    // 덧셈할 문자열 리턴
    public String getFormula() {
        return formula;
    }
}
