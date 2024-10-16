package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final String INPUT_GUIDE = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_RESULT = "결과 : ";

    private static final String BASIC_DELIMITER_1 = ",";
    private static final String BASIC_DELIMITER_2 = ":";

    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";

    private static final String LEFT_SQUARE_BRACKET = "[";
    private static final String RIGHT_SQUARE_BRACKET = "]";
    private static final String REGEX_OR_OPERATOR = "|";

    public static void main(String[] args) {
        // 입력
        System.out.println(INPUT_GUIDE);
        String input = Console.readLine();

        // 구분자 정의
        String[] delimiter = new String[3];
        delimiter[0] = BASIC_DELIMITER_1;
        delimiter[1] = BASIC_DELIMITER_2;

        // 커스텀 구분자 확인
        if (input.startsWith(CUSTOM_DELIMITER_START)) {
            int customEndIndex = input.indexOf(CUSTOM_DELIMITER_END);
            delimiter[2] = input.substring(2, customEndIndex);

            // 커스텀 구분자 필드 제거
            input = input.substring(customEndIndex + 2);
        }

        // 구분자 배열을 정규식 패턴으로 변환
        // ex. {",", ":", ";"} -> [,|:|;]
        String regex = LEFT_SQUARE_BRACKET + String.join(REGEX_OR_OPERATOR, delimiter) + RIGHT_SQUARE_BRACKET;

        // 숫자 추출
        String[] split = input.split(regex);
        int result = 0;
        for (String strNum : split) {
            result += Integer.parseInt(strNum);
        }

        // 출력
        System.out.println(OUTPUT_RESULT + result);

        // scanner 닫기
        Console.close();
    }
}
