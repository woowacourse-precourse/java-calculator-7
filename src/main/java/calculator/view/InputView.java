package calculator.view;

import calculator.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    public static String readString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();
        if (!Validator.checkDefaultDelimterFormat(inputString) && !Validator.checkCustomDelimiterFormat(inputString)){
            throw new IllegalArgumentException("(기본 구분자를 활용한 입력 포맷) 또는 (커스텀 구분자 지정 포맷)이 잘못되었습니다.");
        }

        return inputString;
    }

}
