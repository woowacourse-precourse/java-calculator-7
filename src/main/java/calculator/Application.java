package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// //;\\n1//]\\n;1-
public class Application {
    static String sepeartor = ",|:";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 문자열 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        // 커스텀 구분자
        if (str.contains("//") && str.contains("\\n")) {
            str = getCustomSeparator(str);
        }
        System.out.println("커스텀 구분자 제거: " + str);

        // 유효성 검사 & 숫자 반환
        String[] numbers = parseAndValidateNumbers(str);

        // 결과 출력
        System.out.println("결과 : " + str);
    }

    /**
     * 커스텀 구분자를 추출하는 함수 정규식을 활용함
     *
     * @param str 입력받은 문자열
     * @return 커스텀 구분자 지정 문자를 모두 제거한 문자열
     */
    private static String getCustomSeparator(String str) {
        Pattern pattern = Pattern.compile("//(.*?)\\\\\\n");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) { //일치하는 게 있다면
            sepeartor += "|" + matcher.group(1);
            //System.out.println("추출된 구분자: " + sepeartor);
        }

        // 문자열에서 //로 시작하고 \\n으로 끝나는 모든 패턴을 제거
        str = str.replaceAll("//.*?\\\\n", "");

        return str;
    }

    /**
     * 입력한 문자열의 유효성을 검사하고 유효하다면 숫자로된 문자열 배열 반환
     *
     * @param str 커스텀 구분자를 나타내는 문자를 제거한 문자열
     * @return 숫자 문자열 배열
     */
    private static String[] parseAndValidateNumbers(String str) {
        //구분자를 기준으로 문자열을 분리
        String[] numbers = str.split(sepeartor);

        for (String number : numbers) {
            //각 부분이 숫자로만 이루어져 있는지 확인 (빈 문자열 무시)
            if (!number.trim().isEmpty() && !number.matches("\\d+")) {
                throw new IllegalArgumentException("잘못된 입력입니다. ");
            }
        }
        return numbers;
    }
}
