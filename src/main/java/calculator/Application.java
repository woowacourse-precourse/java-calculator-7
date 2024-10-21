package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    // delimiter 변수를 클래스 필드로 선언
    private static String delimiter = ",|:";  // 기본 구분자

    public static void main(String[] args) {
        // 사용자로부터 문자열을 입력받음
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 입력 문자열을 디버깅 용도로 출력
        System.out.println("입력한 문자열: " + input);  // 입력된 문자열 확인

        try {
            int result = add(input);
            System.out.println("결과: " + result);
        } catch (Exception e) {
            System.out.println("에러 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;  // 빈 문자열 또는 null 입력 시 0 반환
        }

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            input = customSeparator(input);  // 커스텀 구분자 처리
        }

        // 구분자를 기준으로 문자열 분리
        String[] tokens = input.split(delimiter);  // delimiter 사용해 분리
        int sum = 0;

        // 숫자 합산 처리
        for (String token : tokens) {
            sum += Integer.parseInt(token.trim());  // 문자열을 숫자로 변환 후 합산
        }

        return sum;  // 합산 결과 반환
    }

    // 커스텀 구분자 처리 메서드
    private static String customSeparator(String input) {
        int separatorIndex = input.indexOf("\\n");  // '\n' 대신 문자열 '\\n' 처리

        // '\\n'이 없는 경우 예외 처리
        if (separatorIndex == -1) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }

        delimiter = input.substring(2, separatorIndex);  // 커스텀 구분자 추출
        input = input.substring(separatorIndex + 2);  // 구분자 이후 문자열 추출

        // 정규식 메타 문자인 경우 이스케이프 처리
        delimiter = escapeSpecialRegexChars(delimiter);

        return input;  // 본문 문자열 반환
    }

    // 정규식 특수 문자를 이스케이프 처리하는 메서드
    private static String escapeSpecialRegexChars(String delimiter) {
        return delimiter.replaceAll("([\\W])", "\\\\$1");
    }
}
