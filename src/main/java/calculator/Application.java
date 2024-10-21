package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int sum = 0;
        char c;
        char customSep;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = readLine();

        // 정상적인 커스텀 구분자 입력이 있을 때
        Pattern customSepPattern = Pattern.compile("//.\\\\n");
        Matcher m = customSepPattern.matcher(inputStr);
        boolean isCustomForm = m.find();

        if (isCustomForm) {
            // 커스텀 구분자 추출 및 커스텀 구분자 지정 형식 제거하기
            customSep = inputStr.charAt(5);
            inputStr = inputStr.substring(5);

            for (int i = 0; i < inputStr.length(); i++) {
                c = inputStr.charAt(i);
                // 짝수 번째 인덱스는 숫자 입력
                if (i % 2 == 0) {
                    // 숫자 관련 예외 처리: 숫자가 아닌지 확인, 음수인지 확인
                    // 결과값에 더하기
                    sum += Character.getNumericValue(c);
                }

                // 홀수 번째 인덱스는 문자 입력
                if (i % 2 ==1) {
                    // 문자 관련 예외 처리: 지정된 구분자를 사용했는지 확인
                }
            }
        }

        if (!isCustomForm) {
            for (int i = 0; i < inputStr.length(); i++) {
                c = inputStr.charAt(i);
                // 짝수 번째 인덱스는 숫자 입력
                if (i % 2 == 0) {
                    // 숫자 관련 예외 처리: 숫자가 아닌지 확인, 음수인지 확인
                    // 결과값에 더하기
                    sum += Character.getNumericValue(c);
                }

                // 홀수 번째 인덱스는 문자 입력
                if (i % 2 ==1) {
                    // 문자 관련 예외 처리: 지정된 구분자를 사용했는지 확인
                }
            }
        }

        System.out.println("결과 : " + sum);
    }
}
