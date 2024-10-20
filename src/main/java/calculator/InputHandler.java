package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private static final String CUSTOM_DELIMITERS_PREFIX = "//";
    private static final String CUSTOM_DELIMITERS_SUFFIX = "\\n";
    private static final String DEFAULT_DELIMITERS = ",|:";

    // 사용자 입력 받기
    public String getInput() {
        String input = Console.readLine();
        if (input == null || input.trim().isEmpty()) {
            System.out.println(0);
            System.exit(0); // 입력이 없을 경우 프로그램 종료
        }
        return input;
    }

    // 입력에서 구분자를 추출
    public String getDelimiters(String input) {
        if (input.startsWith(CUSTOM_DELIMITERS_PREFIX)) {
            int start = CUSTOM_DELIMITERS_PREFIX.length();
            int end = input.indexOf(CUSTOM_DELIMITERS_SUFFIX, start);
            if (end == -1) {
                throw new IllegalArgumentException("구분자가 잘못 설정되었습니다.");
            }
            return input.substring(start, end); // 커스텀 구분자 반환
        }
        return DEFAULT_DELIMITERS; // 기본 구분자 반환
    }

    // 입력 문자열에서 구분자 부분 제거
    public String getProcessedInput(String input) {
        if (input.startsWith(CUSTOM_DELIMITERS_PREFIX)) {
            int delimiterEndIndex = input.indexOf(CUSTOM_DELIMITERS_SUFFIX) + 2; // "\n" 뒤부터 데이터 시작
            return input.substring(delimiterEndIndex);
        }
        return input; // 기본 입력 문자열 그대로 반환
    }
}
