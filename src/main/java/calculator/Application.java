package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int calculateString(String str) {
        // 문자열이 비어있거나 null이면 0을 출력
        if (str == null || str.isEmpty()) {
            return 0;
        } else {
            // 기본 구분자를 ",:"d으로 정함
            String separator = "[,:]";

            // 커스텀 구분자를 사용하는지 확인
            if (str.startsWith("//")) {
                // 커스텀 구분자가 "//"로 시작하면 구분자 찾기
                separator = changeCustomSeparator(str);
                // 구분자 뒤 숫자 추출
                str = extractNumber(str);
                // 구분자를 이스케이프 처리
                separator = escapeCharacters(separator);
            }
            // 설정된 구분자로 문자열 분리
            String[] numbers = str.split(separator);

            // 숫자 합계 계산
            int result = 0;
            for (String number : numbers) {
                result += validateInput(number);
            }
            return result;
        }
    }

    // 커스텀 구분자 변경 메소드
    private static String changeCustomSeparator(String str) {
        // "\n" 문자열이 있는지 확인
        int separatorIndex = str.indexOf("\\n");
        if (separatorIndex != -1) {
            // "//"과 "\n" 사이의 커스텀 구분자로 구분자 변경
            return str.substring(2,separatorIndex);
        } else {
            throw new IllegalArgumentException("잘못된 구분자입니다.");
        }
    }

    // 문자열에서 커스텀 구분자 제외한 숫자 추출 메소드
    private static String extractNumber(String str) {
        int separatorIndex = str.indexOf("\\n");
        return str.substring(separatorIndex + 2);
    }

    // 특수문자에 이스케이프 처리 메소드
    private static String escapeCharacters(String separator) {
        String specialCharacters = "[](){}.*+?^$|\\";
        StringBuilder escapedSeparator = new StringBuilder();
        for (int i = 0; i < separator.length(); i++) {
            char ch = separator.charAt(i);
            if (specialCharacters.indexOf(ch) != -1) {
                // 특수 문자 앞에 \를 추가하여 이스케이프 처리
                escapedSeparator.append("\\");
            }
            escapedSeparator.append(ch);
        }
        return escapedSeparator.toString();
    }

    // 유효한 문자열 입력 검사 메소드
    private static int validateInput(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            } else {
                return num;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요. ");
        String str = Console.readLine();
        // 계산 결과 출력
        int answer = calculateString(str);
        System.out.println("결과 : " + answer);
    }
}
