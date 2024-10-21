package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int sum = 0;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = readLine();

        // 정상적인 커스텀 구분자 입력이 있을 때
        Pattern customSepPattern = Pattern.compile("//.\\\\n");
        Matcher m = customSepPattern.matcher(inputStr);
        boolean isCustomForm = m.find();

        if (isCustomForm) {
            // 정상적인 커스텀 구분자 입력인 경우
            // 문자와 숫자의 입력을 받고 각각 예외 처리 적용
        }

        if (!isCustomForm) {
            // 비정상적인 커스텀 구분자 입력도 여기로 들어오지만, 숫자 또는 문자 입력 확인에서 예외 처리가 된다.
            // 문자와 숫자의 입력을 받고 각각 예외 처리 적용
        }

        System.out.println("결과 : " + sum);
    }
}
